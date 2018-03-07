import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author huangtt
 *
 */
public class Version1{
	
	public static void main(String[] args) {
		
		long before = System.currentTimeMillis();	
		long run=4000000000L;
		double x,y;
		long outCircle=0;
		ThreadLocalRandom random = ThreadLocalRandom.current(); //https://www.concretepage.com/java/jdk7/threadlocalrandom-java-example
		
		for(long l=0; l<run; l++) {
			x=random.nextDouble();
			y=random.nextDouble();
			if((x*x+y*y)>1.0)
				outCircle++;
		} 
		
		System.out.println((double)(run-outCircle)/run*4);	
		System.out.println("Time: "+(System.currentTimeMillis()-before)+" ms");
	}
}
