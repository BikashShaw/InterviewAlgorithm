package producerconsumer.reentrantlock;

import producerconsumer.runner.IProducerConsumer;
import producerconsumer.runner.Runner;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Bikash on 4/3/2017.
 */
public class ProducerConsumer implements IProducerConsumer  {
    public static int MAX_QUEUE_SIZE = 10;
    LinkedList<Integer> queue = new LinkedList<>();
    ReentrantLock lock;
    Condition condition;

    public ProducerConsumer() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {

            lock.lock();
            if (queue.size() == MAX_QUEUE_SIZE) {
                condition.await();
            }
            try {
                int e = random.nextInt(1000);
                queue.add(e);
                System.out.println("Added: " + e + " Current queue size: " + queue.size());
                condition.signal();
                Thread.sleep(500);
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {

            lock.lock();

            if (queue.isEmpty()) {
                condition.await();
            }
            try {
                Integer e = queue.removeFirst();
                System.out.println("Removed: " + e + " Current queue size: " + queue.size());
                condition.signal();
                Thread.sleep(500);
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Runner<ProducerConsumer>().run(new ProducerConsumer());
    }

}
