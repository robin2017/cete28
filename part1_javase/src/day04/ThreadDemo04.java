package day04;

public class ThreadDemo04 {
    static Object obj=new Object();
    static void delay(int time) {
        try {
            Thread.sleep(time);
        }catch(Exception e) {
            System.out.println("error");
        }
    }
    static class SubThread1 extends Thread{
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("Thread1.start");
                delay(7000);
                System.out.println("Thread1.end");
            }
        }
    }
    static class SubThread2 extends Thread{
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("Thread2.start");
                delay(2000);
                System.out.println("Thread2.end");
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Main.start");
        SubThread1 t1=new SubThread1();
        t1.start();
        delay(2000);
        SubThread2 t2=new SubThread2();
        t2.start();
        delay(1000);
        t2.interrupt();
        System.out.println("Main.end");
    }
}
