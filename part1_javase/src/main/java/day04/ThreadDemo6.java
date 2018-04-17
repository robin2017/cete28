package day04;

/**
 * Created by robin on 2017/7/29.
 */
public class ThreadDemo6 {
    static String context;
    public final static Object lock = new Object();
    public static void main(String[] args)
            throws InterruptedException {

        new Thread() {
            public void run() {
                synchronized (lock) {
                    context = "hello";
                    lock.notify();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                synchronized (lock) {
                    try {
                        if(context==null)
                            lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(context.toUpperCase());
                }
            }
        }.start();
    }
}
