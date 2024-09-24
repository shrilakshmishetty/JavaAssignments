//Q6:Write a program for  InterThread communication(Producer-Consumer) with wait() and notify() and also with LinkedBlockingQueue()
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable{
	BlockingQueue<Integer> obj; 
	  
    public Producer(BlockingQueue<Integer> obj) 
    { 
        
        this.obj = obj; 
    } 
  
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=3;i++) {
			try {
				obj.put(i);
				
				System.out.println("Produced" +i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
class Consumer implements Runnable{
	BlockingQueue<Integer> obj; 
	  
    public Consumer(BlockingQueue<Integer> obj) 
    { 
        this.obj = obj; 
    } 
  

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=-1;
		while(i!=3) {
		try {
			i=obj.take();
		
			System.out.println("Consumed" +i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
}
public class MultiThreading6 {
	public static void main(String[] args) throws InterruptedException {
		 BlockingQueue<Integer> bqueue = new LinkedBlockingQueue<Integer>(3);
		 Producer p=new Producer(bqueue);
		 Consumer c=new Consumer(bqueue);
		 Thread t1=new Thread(p);
		 Thread t2=new Thread(c);
		t1.start();
		t1.join();
		t2.start();
	}

}
