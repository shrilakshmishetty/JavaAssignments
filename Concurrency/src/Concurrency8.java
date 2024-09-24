//Q8: Solve the readers-writers problem where multiple readers can access a shared resource simultaneously, but only one writer can access it at a time.
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource3 {
    private int data = 0; 
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void readResource1(String threadName) {
        rwLock.readLock().lock(); 
        try {
            System.out.println(threadName + " is reading: " + data);
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.readLock().unlock(); 
        }
    }
    public void writeResource1(String threadName, int value) {
        rwLock.writeLock().lock(); 
        try {
            System.out.println(threadName + " is writing: " + value);
            Thread.sleep(500);
            data = value;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.writeLock().unlock(); 
        }
    }
}

class Reader implements Runnable {
    private SharedResource3 resource;
    private String threadName;

    public Reader(SharedResource3 resource, String threadName) {
        this.resource = resource;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        resource.readResource1(threadName);
    }
}

class Writer implements Runnable {
    private SharedResource3 resource;
    private String threadName;
    private int value;

    public Writer(SharedResource3 resource, String threadName, int value) {
        this.resource = resource;
        this.threadName = threadName;
        this.value = value;
    }

    @Override
    public void run() {
        resource.writeResource1(threadName, value);
    }
}

public class Concurrency8 {
    public static void main(String[] args) {
        SharedResource3 resource = new SharedResource3();
        Thread r1 = new Thread(new Reader(resource, "Reader 1"));
        Thread r2 = new Thread(new Reader(resource, "Reader 2"));
        Thread r3 = new Thread(new Reader(resource, "Reader 3"));
        Thread w1 = new Thread(new Writer(resource, "Writer 1", 100));
        Thread w2 = new Thread(new Writer(resource, "Writer 2", 200));
        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();
    }
}
