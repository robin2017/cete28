package day02;

/**
 * Created by robin on 2017/7/27.
 */

class Outer01{
     int a;
    /**实例内部类
     * 1、定义：类的方法，方法外部
     * 2、此类的实例依托与外部类对象
     * 3、允许访问外部类任意成员
     * */
     class Inner01{
        public void change(){
            a=100;
        }
    }
}

class Outer02{
    private int s1;
    private static int s2;
    /**静态内部类
     * 1、定义：类的方法，方法外部
     * 2、此类的实例不依托与外部类对象
     * 3、允许访问外部类任意静态成员，不可以非静态
     * */
    static class Inner02{
        public void out(){
            System.out.println(s2);
        }
    }
}

interface IOuter{
    void print();
}
class Outer03{
    /**局部内部类
     * 1、定义：方法内部
     * 2、此类的实例只能在方法内部
     * 3、允许访问外部类任意成员
     * */
    public void display(){
        class Inner03{}
    }
    public void show(){
        new IOuter() {
            @Override
            public void print() {
                System.out.println("ddd");
            }
        };
    }
}

class Outer04{
    /**
     * 内部类（iouter接口的实现类）
     * 因为没有名字，所以叫匿名内部类，
     * */
    public void show(){
        IOuter o1=new IOuter(){
            @Override
            public void print() {
                System.out.print("hello");
            }
        };
        o1.print();//调用
    }
}
public class InnerDemo01 {
    Outer01 o1=new Outer01();
    Outer01.Inner01 io1=o1.new Inner01();




}
