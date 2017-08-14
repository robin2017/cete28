package day05.MXQ;

/**
 * Created by robin on 2017/8/7.
 */

public class test2 {

    public static void main(String[] args) {
		/*
		 * 线程A10  B20
		 * 反复50
		 */
       final Bus bus = new Bus();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                for(int i=0;i<50;i++)
                    bus.send();
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                for(int i=0;i<50;i++)
                    bus.rec();
            }
        }).start();
//        new Thread(new TaskA(bus)).start();
//        new Thread(new TaskB(bus)).start();

    }

}

class TaskA implements Runnable{

    private Bus bus;
    TaskA(Bus bus){
        this.bus=bus;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i=0;i<50;i++)
            bus.send();
    }
}

class TaskB implements Runnable{

    private Bus bus;
    TaskB(Bus bus){
        this.bus=bus;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i=0;i<50;i++)
            bus.rec();
    }
}


class Bus{
    //使用同一个对象的线程 等待池->放同一个类中 方便->this
    private boolean flag;
    //生产者
    synchronized public void send(){
        // TODO Auto-generated method stub
        while(flag) {
            try {
                this.wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        for(int i=0;i<10;i++) {
            System.out.print(" "+i);
        }System.out.println();
        flag = true;
        this.notify();

    }
    //消费者
    synchronized public void  rec() {
        while(!flag) {
            try {
                this.wait();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        for(int i=0;i<20;i++) {
            System.out.print(" "+i);
        }System.out.println();
        flag = false;
        this.notify();

    }
}