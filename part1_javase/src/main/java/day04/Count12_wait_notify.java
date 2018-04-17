package day04;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by robin on 2017/8/6.
 */
public class Count12_wait_notify {
    public static void main(String[] args) {
        Horn horn = new Horn();
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(new Count1(horn));
        executor.execute(new Count2(horn));
    }
}

class Horn {

    private boolean hasCount1 = false; //状态
    public synchronized void Count1() {  //动作
        hasCount1 = true;
        notifyAll();
    }
    public synchronized void Count2() {
        hasCount1 = false;
        notify();
    }
    public synchronized void waitForCount1()
            throws InterruptedException {
        while (hasCount1 == true)
            wait();
    }
    public synchronized void waitForCount2()
            throws InterruptedException {
        while (hasCount1 == false)
            wait();
    }
}

class Count1 implements Runnable {
    private Horn horn;
    public Count1(Horn horn) {
        this.horn = horn;
    }
    @Override
    public void run() {
        while (true) {
            try {
                horn.waitForCount1();
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("1");
                horn.Count1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Count2 implements Runnable {
    private Horn horn;
    public Count2(Horn horn) {
        this.horn = horn;
    }
    @Override
    public void run() {
        while (true) {
            try {
                horn.waitForCount2();
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("2");
                horn.Count2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}