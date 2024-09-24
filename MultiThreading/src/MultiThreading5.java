//Q5: Write a program of Thread, so thread1 should print 1 to 5 and thread2 should print 6 to 10?
class Numbers1to5 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Current Thread : "+Thread.currentThread().getName());
		for(int i=1;i<=5;i++) {
			
			System.out.println(i);
		}
		
	}
	
}
class Numbers6to10 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Current Thread : "+Thread.currentThread().getName());
		for(int i=6;i<=10;i++) {
			System.out.println(i);
		}
		
	}
	
}
public class MultiThreading5 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Numbers1to5());
		t1.start();
		t1.join();
		Thread t2=new Thread(new Numbers6to10());
		t2.start();
		
	}

}
