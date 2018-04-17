package day04;

class Starter extends Thread{
    private int x=2;
    public Starter() {
        x=5;
        start();
    }
    @Override
    public void run() {
//        try{Thread.sleep(3000);}
//        catch(Exception e) {}
        x*=2;
    }
    public void makeItSo()throws Exception {
        join(1000);//插入式线程(调用join方法的那个对象会优先执行)
        x-=1;
        System.out.println("work.x="+x);
    }
}
public class JoinThreadDemo02 {
    public static void main(String[] args)
            throws Exception {
      new Starter().makeItSo();
    }
}
