/*Q2: Write Program to implement your own threadpool and implement class to take runnable and able to submit task.
 * 
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Mythread implements Runnable{

	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		
	}
	
}
public class MultiThreading2 {
	public static void main(String[] args) {
		ExecutorService exec=Executors.newFixedThreadPool(3);
		for(int i=0;i<=5;i++) {
			Thread t=new Thread(new Mythread());
			exec.execute(t);
			
		}
		
	}

}
