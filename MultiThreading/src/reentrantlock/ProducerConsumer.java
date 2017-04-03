package reentrantlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Bikash on 4/3/2017.
 */
public class ProducerConsumer {
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
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
