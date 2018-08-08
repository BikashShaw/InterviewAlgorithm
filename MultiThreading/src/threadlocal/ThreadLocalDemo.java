package threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo implements Runnable {
    private static ThreadLocal<AtomicInteger> counter = ThreadLocal.withInitial(() -> new AtomicInteger(0));


    @Override
    public void run() {
        while (true) {
            System.out.println(String.format("From thread %s - Counter value %d", Thread.currentThread().getName(), counter.get().incrementAndGet()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadLocalDemo(), "T1");
        Thread t2 = new Thread(new ThreadLocalDemo(), "T2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
