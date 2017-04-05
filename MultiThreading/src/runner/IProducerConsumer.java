package runner;

/**
 * Created by Bikash on 4/4/2017.
 */

public interface IProducerConsumer {
    void produce() throws InterruptedException;
    void consume() throws InterruptedException;
}
