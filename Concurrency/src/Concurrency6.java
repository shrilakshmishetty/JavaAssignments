//Q6: Solve a problem using semaphores, for example, implement a scenario where a certain number of threads can concurrently access a resource.
import java.util.concurrent.Semaphore;

class SharedResource2 {
    private Semaphore semaphore;

    public SharedResource2(int permits) {
        this.semaphore = new Semaphore(permits); // Allow only a certain number of threads to access
    }

    public void accessResource(String threadName) {
        try {
            semaphore.acquire(); // Acquire a permit before accessing the resource
            System.out.println(threadName + " is accessing the resource");
            Thread.sleep(1000); // Simulate resource usage
            System.out.println(threadName + " is releasing the resource");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Release the permit after accessing the resource
        }
    }
}

class Worker implements Runnable {
    private SharedResource2 resource;
    private String threadName;

    public Worker(SharedResource2 resource, String threadName) {
        this.resource = resource;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        resource.accessResource(threadName);
    }
}

public class Concurrency6 {
    public static void main(String[] args) {
        SharedResource2 resource = new SharedResource2(3); // Only 3 threads can access the resource at the same time

        Thread t1 = new Thread(new Worker(resource, "Thread 1"));
        Thread t2 = new Thread(new Worker(resource, "Thread 2"));
        Thread t3 = new Thread(new Worker(resource, "Thread 3"));
        Thread t4 = new Thread(new Worker(resource, "Thread 4"));
        Thread t5 = new Thread(new Worker(resource, "Thread 5"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

