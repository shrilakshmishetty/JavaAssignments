//Q5: Create a scenario that can lead to a deadlock. Write a program that detects the deadlock and resolves it programmatically.
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class Concurrency5 {
 
    private static final ReentrantLock ResourceA = new ReentrantLock();
    private static final ReentrantLock ResourceB = new ReentrantLock();
 
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(ResourceA, ResourceB), "Thread1");
        Thread thread2 = new Thread(new Task(ResourceB, ResourceA), "Thread2");
 
        thread1.start();
        thread2.start();
    }
 
    static class Task implements Runnable {
        private final ReentrantLock firstLock;
        private final ReentrantLock secondLock;
 
        public Task(ReentrantLock firstLock, ReentrantLock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }
 
        @Override
        public void run() {
            try {
                if (firstLock.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + firstLock);
 
                    Thread.sleep(100);
 
                    if (secondLock.tryLock()) {
                        System.out.println(Thread.currentThread().getName() + " acquired " + secondLock);
 
                        Thread.sleep(100);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " could not acquire " + secondLock);
                    }
 
                    if (secondLock.isHeldByCurrentThread()) {
                        secondLock.unlock();
                        System.out.println(Thread.currentThread().getName() + " released " + secondLock);
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire " + firstLock);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                if (firstLock.isHeldByCurrentThread()) {
                    firstLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released " + firstLock);
                }
            }
        }
    }
}

