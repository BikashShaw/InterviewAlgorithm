package basic;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> createRunnable(10), "T1");

        Thread t2 = new Thread(() -> createRunnable(30), "T2");

        t1.start();
        t2.start();

        t1.join();
        System.out.println("Main Finished!");
    }

    private static void createRunnable(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
