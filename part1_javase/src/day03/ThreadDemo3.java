package day03;

/**
 * Created by robin on 2017/7/28.
 */
public class ThreadDemo3 {
    /**代表一个售票系统*/
    static class TicketTask implements Runnable{
        int ticket=10;
        @Override
        public void run() {
            while (true){
                synchronized (this) {
                    if (ticket <= 0)
                        break;
                    System.out.println(ticket);
                    ticket--;
                }
            }
        }
    }
    public static void main(String[] args){
        //任务
        TicketTask task=new TicketTask();
        //线程
        Thread thread1=new Thread(task);
        Thread thread2=new Thread(task);
        Thread thread3=new Thread(task);
        Thread thread4=new Thread(task);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
