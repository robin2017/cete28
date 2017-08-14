package day03;

/**
 * Created by robin on 2017/7/28.
 */
public class ThreadDemo {
    static void method1(){while(true)System.out.println("method1");}
    static void method2(){while(true)System.out.println("method2");}
    public static void main(String[] args){

      new Thread(){
            public void run(){
                method1();
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        }).start();


    }
}
