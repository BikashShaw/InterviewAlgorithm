package deadlock;

/**
 * jvisualvm.exe OUTPUT:
 * <p>
 * Found one Java-level deadlock:
 * =============================
 * "T2":
 * waiting to lock monitor 0x00000000171cd658 (object 0x00000000d5f16778, a java.lang.Object),
 * which is held by "T1"
 * "T1":
 * waiting to lock monitor 0x00000000189c88f8 (object 0x00000000d5f16788, a java.lang.Object),
 * which is held by "T2"
 * <p>
 * Java stack information for the threads listed above:
 * ===================================================
 * "T2":
 * at deadlock.MyThread2.run(DeadLockDemo.java:73)
 * - waiting to lock <0x00000000d5f16778> (a java.lang.Object)
 * - locked <0x00000000d5f16788> (a java.lang.Object)
 * at java.lang.Thread.run(Thread.java:748)
 * "T1":
 * at deadlock.MyThread1.run(DeadLockDemo.java:47)
 * - waiting to lock <0x00000000d5f16788> (a java.lang.Object)
 * - locked <0x00000000d5f16778> (a java.lang.Object)
 * at java.lang.Thread.run(Thread.java:748)
 * <p>
 * Found 1 deadlock.
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        MyThread1 myThread1 = new MyThread1(lock1, lock2);
        MyThread2 myThread2 = new MyThread2(lock1, lock2);

        Thread t1 = new Thread(myThread1, "T1");
        Thread t2 = new Thread(myThread2, "T2");

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

class MyThread1 implements Runnable {

    private final Object resource1;
    private final Object resource2;

    public MyThread1(Object resource1, Object resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            System.out.println(String.format("%s acquire the lock of resource1", Thread.currentThread().getName()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource2) {
                System.out.println(String.format("%s acquire the lock of resource2", Thread.currentThread().getName()));
            }
        }
    }
}

class MyThread2 implements Runnable {

    private final Object resource1;
    private final Object resource2;

    public MyThread2(Object resource1, Object resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource2) {
            System.out.println(String.format("%s acquire the lock of resource2", Thread.currentThread().getName()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource1) {
                System.out.println(String.format("%s acquire the lock of resource1", Thread.currentThread().getName()));
            }
        }
    }
}
