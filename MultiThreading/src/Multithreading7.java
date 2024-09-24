//Q7: Write a program that uses ThreadLocal to maintain a unique value for each thread and demonstrate its use in a multithreaded environment.
class Mythread1 implements Runnable{
	ThreadLocal<Integer> thread=new ThreadLocal<>();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count=1;
		thread.set((int) (Math.random() * 50D) );
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		System.out.println(Thread.currentThread().getName()+" : "+thread.get());
		
	}
	
}
public class Multithreading7 {
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<5;i++) {
			Thread t=new Thread(new Mythread1());
			t.start();
			
		}
		
	}

}
