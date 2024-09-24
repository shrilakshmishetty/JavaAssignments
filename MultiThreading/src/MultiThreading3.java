/*Q3: Write a program with three threads. First thread should print Even numbers, Second thread should print Odd Numbers, third thread should print sum of odd and even numbers. Above threads should print in a sequential manner.
 * 
 */
public class MultiThreading3 {
	
	static class PrintEven implements Runnable{
		public void run() {
			System.out.println("Even numbers :");
			for(int i=0;i<=10;i++) {
				if(i%2==0) {
					System.out.println(i);
				}
				}
			
		}
	}
		static class PrintOdd implements Runnable{
			public void run() {
				System.out.println("Odd numbers :");
				for(int i=0;i<=10;i++) {
					if(i%2!=0) {
						System.out.println(i);
					}
					}
				
			}
		}
			static class Sum implements Runnable{
				int sum=0;
				public void run() {
					System.out.println("Sum of numbers :");
					for(int i=0;i<=10;i++) {
						sum+=i;
					
					}
						
							System.out.println(sum);
						
						}
					
				}
			public static void main(String[] args) throws InterruptedException {
				Runnable printEven = new PrintEven();
		        Runnable printOdd = new PrintOdd();
		        Runnable sum = new Sum();

		        
		        Thread thread1 = new Thread(printEven);
		        Thread thread2 = new Thread(printOdd);
		        Thread thread3 = new Thread(sum);

		     
		        thread1.start();
		        thread1.join();
		        thread2.start();
		        thread2.join();
		        thread3.start();
		      
		        
		      
				
			}
	
		
	

		
	
}
