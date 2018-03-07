import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author huangtt
 *
 */
public class Version2 extends Thread{  

	public void run(){  
		double x,y;
		ThreadLocalRandom random = ThreadLocalRandom.current(); //https://www.concretepage.com/java/jdk7/threadlocalrandom-java-example
		for(long l=0; l<perThread; l++) {
			x=random.nextDouble();
			y=random.nextDouble();
			if((x*x+y*y)>1.0)
				this.outCircle++;
		}

	} 
	

	long outCircle=0L;
	final static long TRIAL=4000000000L;
	final static int NUM_OF_THREAD=4;
	final long perThread=TRIAL/NUM_OF_THREAD;
	
	public static void main(String args[]){ 
		long before = System.currentTimeMillis();
		long outCircle=0;
		try {
			//learn thread from https://www.tutorialspoint.com/java/java_multithreading.htm
			Version2[] v=new Version2[NUM_OF_THREAD];
			for(int i=0; i<NUM_OF_THREAD; i++) {
				v[i]=new Version2();
				v[i].start();
			}
			
			for(int i=0; i<NUM_OF_THREAD; i++) {
				v[i].join(); //https://stackoverflow.com/questions/15347643/print-data-after-all-the-threads-finished
				outCircle+=v[i].outCircle;
			}
			System.out.println("Open thread: "+NUM_OF_THREAD);
			System.out.println((double)(TRIAL-outCircle)/TRIAL*4);
			System.out.println("Time:"+(System.currentTimeMillis()-before)+" ms");
			
			
		}catch(	InterruptedException e) {
			System.out.println("Thread is interrupted");
		}
	} 
 
}