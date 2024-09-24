//Q4: Write a program where multiple threads increment a shared counter using AtomicInteger and ensure that the increments are atomic.
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getValue() {
        return counter.get();
    }
}

class CounterIncrementer implements Runnable {
    private Counter counter;

    public CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Concurrency4 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(new CounterIncrementer(counter), "Thread 1");
        Thread t2 = new Thread(new CounterIncrementer(counter), "Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value: " + counter.getValue());
    }
}
