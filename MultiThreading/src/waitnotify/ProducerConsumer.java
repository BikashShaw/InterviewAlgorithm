package waitnotify;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Bikash on 4/3/2017.
 */
public class ProducerConsumer {
    public static int MAX_QUEUE_SIZE = 10;
    LinkedList<Integer> queue = new LinkedList<>();
    Object lock;

    public ProducerConsumer() {
        lock = new Object();
    }

    public void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {

            synchronized (lock) {
                if (queue.size() == MAX_QUEUE_SIZE) {
                    lock.wait();
                }
                int e = random.nextInt(1000);
                queue.add(e);
                System.out.println("Added: " + e + " Current queue size: " + queue.size());
                lock.notify();
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (queue.isEmpty()) {
                    lock.wait();
                }
                Integer e = queue.removeFirst();
                System.out.println("Removed: " + e + " Current queue size: " + queue.size());
                lock.notify();
                Thread.sleep(500);
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
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
