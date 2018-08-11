package basic;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1");
        }, "T1");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2");
        }, "T2");

        t1.start();
        t2.start();

        t1.join();
        System.out.println("Main Finished!");
    }
}
