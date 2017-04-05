package runner;

/**
 * Created by Bikash on 4/4/2017.
 */
public class Runner<T extends IProducerConsumer> {
    public void run(T producerConsumer) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
