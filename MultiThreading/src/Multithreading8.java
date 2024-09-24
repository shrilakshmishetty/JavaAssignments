
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
}

class Producerr1 implements Runnable {
    private final BoundedBuffer buffer;

    public Producerr1(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer1 implements Runnable {
    private final BoundedBuffer buffer;

    public Consumer1(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.consume();
                Thread.sleep(150);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Multithreading8 {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();

        Thread producer = new Thread(new Producerr1(buffer));
        Thread consumer = new Thread(new Consumer1(buffer));

        producer.start();
        consumer.start();
    }
}

