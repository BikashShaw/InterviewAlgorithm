package blockingqueue;

import runner.IProducerConsumer;
import runner.Runner;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Bikash on 4/3/2017.
 */
public class ProducerConsumer implements IProducerConsumer {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            int e = random.nextInt(1000);
            queue.put(e);
            System.out.println("Added: " + e + " Current queue size: " + queue.size());
            Thread.sleep(500);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            Integer e = queue.take();
            System.out.println("Removed: " + e + " Current queue size: " + queue.size());
            Thread.sleep(800);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Runner<ProducerConsumer>().run(new ProducerConsumer());
    }

}
