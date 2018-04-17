package day04.homework.title2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 客户端
 */
public class OneThreadMultiRunnable {
    /**主函数*/
    public static void  main(String[] args){

        OneThread thread=new OneThread();
        thread.addTask(new Task());
        thread.addTask(new Task());
        thread.addTask(new Task());
        thread.addTask(new Task());
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.addTask(new Task());
        thread.addTask(new Task());
        thread.addTask(new Task());
        thread.addTask(new Task());

    }

}
/**任务*/
class Task implements Runnable{
    /**ID起始*/
    private static int taskCount=0;
    /**ID*/
    private final int id=taskCount++;
    @Override
    public void run() {
        System.out.println("task " + id + " is start running");
        //我希望一直占用CPU呢
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("task " + id + " is end running");
    }
}

/**单线程*/
class OneThread extends Thread {
    /**任务缓存*/
    private BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(10);
    /**当前任务*/
    private Runnable cur;
    /**构造器*/
    public OneThread(BlockingQueue<Runnable> queue){
        this.queue=queue;
    }
    /**构造器*/
    public OneThread(){}
    /**添加任务*/
    public void addTask(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while(true){
            try {
                cur=queue.take();
                cur.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}