package day04dd;

import java.util.concurrent.*;

/**
 * Created by robin on 2017/8/6.
 */
public class Count12_blockingqueue {
    public static void main(String[] args) {
        Horn horn = new Horn();
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(new Count1(horn));
        executor.execute(new Count2(horn));
    }
}
class Horn {
    private ArrayBlockingQueue<Boolean> queue
            =new ArrayBlockingQueue<Boolean>(1);
    public synchronized void Count1()
            throws InterruptedException {  //动作
      queue.put(true);
    }
    public synchronized void Count2()
            throws InterruptedException {
      queue.take();
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
                TimeUnit.MILLISECONDS.sleep(1000);
                horn.Count1();
                System.out.println("1");
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
                TimeUnit.MILLISECONDS.sleep(1000);
                horn.Count2();
                System.out.println("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}