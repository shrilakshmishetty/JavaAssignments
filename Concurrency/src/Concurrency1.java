//Q1: Write a program for Object level and method level synchronization.
class SharedResource {
 
    public void objectLevelSync() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is in object-level synchronized block");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " is leaving object-level synchronized block");
        }
    }


    public synchronized void methodLevelSync() {
        System.out.println(Thread.currentThread().getName() + " is in method-level synchronized block");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " is leaving method-level synchronized block");
    }
}

public class Concurrency1 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

    
        Thread t1 = new Thread(() -> sharedResource.objectLevelSync(), "Thread 1");
        Thread t2 = new Thread(() -> sharedResource.objectLevelSync(), "Thread 2");

        Thread t3 = new Thread(() -> sharedResource.methodLevelSync(), "Thread 3");
        Thread t4 = new Thread(() -> sharedResource.methodLevelSync(), "Thread 4");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
