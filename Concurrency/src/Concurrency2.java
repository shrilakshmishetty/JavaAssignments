//Q2: Write a program for class level locking and object level locking
class SharedResource1 {

  
    public void objectLevelLock() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is in object-level locked block");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " is leaving object-level locked block");
        }
    }
    public static void classLevelLock() {
        synchronized (SharedResource1.class) {
            System.out.println(Thread.currentThread().getName() + " is in class-level locked block");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " is leaving class-level locked block");
        }
    }
}

public class Concurrency2 {
    public static void main(String[] args) {
        SharedResource1 resource1 = new SharedResource1();
        SharedResource1 resource2 = new SharedResource1();
        Thread t1 = new Thread(() -> resource1.objectLevelLock(), "Thread 1");
        Thread t2 = new Thread(() -> resource1.objectLevelLock(), "Thread 2");
        Thread t3 = new Thread(SharedResource1::classLevelLock, "Thread 3");
        Thread t4 = new Thread(SharedResource1::classLevelLock, "Thread 4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
