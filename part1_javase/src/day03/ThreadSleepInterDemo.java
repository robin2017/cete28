package day03;

/**
 * Created by robin on 2017/7/28.
 */
public class ThreadSleepInterDemo {
    static String content;
    public static void main(String[] args){
        final Thread mThread=Thread.currentThread();
        new Thread(){
            public void run(){
                content="helloworld";
                mThread.interrupt();
            }
        }.start();
        if(content==null){
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(content.toUpperCase());
    }
}
