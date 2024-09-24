/*Q4:  Write a program to count , how many times a method was accessed by threads, in a multi-thread environment.
 * 
 */
	

public class Multhithreading4 implements Runnable{
	static int count=0;
	void method() {
		count++;
		
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		method();
		
		
	}
	

	public static  void main(String[] args) throws InterruptedException {
	Thread t1=new Thread(new Multhithreading4());
	Thread t2=new Thread(new Multhithreading4());
	t1.start();
	t1.join();
	t2.start();
	t2.join();
	System.out.println(count +" "+Thread.currentThread().getName() );
	
		
	}

}
