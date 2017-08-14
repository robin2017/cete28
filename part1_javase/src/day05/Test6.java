package day05;

/**
 * Created by robin on 2017/8/7.
 */
public class Test6 {
    public  static void main(String[] args)  {
        Flag flag=new Flag();
        new Thread(new TaskA(flag)).start();
        new Thread(new TaskB(flag)).start();

    }
}

class TaskA implements Runnable{
    private Flag flag;
    public TaskA(Flag flag){
        this.flag=flag;
    }
    @Override
    public void run() {
        try {
            for(int i=0;i<50;i++)
                flag.turnA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskB implements Runnable{
    private Flag flag;
    public TaskB(Flag flag){
        this.flag=flag;
    }
    @Override
    public void run() {
        try {
            for(int i=0;i<50;i++)
               flag.turnB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




class Flag{
    boolean flag=true;
    synchronized void  turnA() throws InterruptedException {
        //System.out.println("turn a");
        while(flag)
            this.wait();
        for(int i=0;i<10;i++)
            System.out.println("a"+i);
        flag=true;
        this.notify();
    }
    synchronized void  turnB() throws InterruptedException {
        //System.out.println("turn b");
        while(!flag)
            this.wait();
        for(int i=0;i<20;i++)
            System.out.println("b"+i);
        flag=false;
        this.notify();
    }
}

class Flag3{
    boolean flag1=true;
    boolean flag2=false;
    boolean flag3=false;
    Object object1=new Object();
    Object object2=new Object();
    Object object3=new Object();
    void  turnA() throws InterruptedException {
        //System.out.println("turn a");
        synchronized (object1) {
            while (flag1)
                this.wait();
            for (int i = 0; i < 10; i++)
                System.out.println("a" + i);
            flag1 = true;
            flag2=true;
            object1.notify();
        }
    }
     void  turnB() throws InterruptedException {
        //System.out.println("turn b");
         synchronized(object2) {
             while (flag2)
                 this.wait();
             for (int i = 0; i < 20; i++)
                 System.out.println("b" + i);
             flag2 = true;
             flag3=true;
             this.notify();
         }
    }
    void  turnC() throws InterruptedException {
        //System.out.println("turn b");
        synchronized(object3) {
            while (flag3)
                this.wait();
            for (int i = 0; i < 30; i++)
                System.out.println("b" + i);
            flag3 = true;
            flag1=true;
            this.notify();
        }
    }
}