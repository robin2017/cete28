package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 2017/7/28.
 */
public class ThreadDemo4 {
    static List<String> list=new ArrayList<String>();
    static class Thread1 extends Thread{
        public void run(){
            list.add("ab");//add,size++,扩容  add是一个线程不安全方法
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("cd");
        }
    }

    static class Thread2 extends Thread{
        public void run(){
            list.add("ef");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("gh");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread1();
        Thread thread2=new Thread2();
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(list);
    }
}
