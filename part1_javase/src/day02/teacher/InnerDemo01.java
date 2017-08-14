package day02.teacher;

//导入一个内部类
import day02.teacher.Outer01.Inner01;
import day02.teacher.Outer02.Inner02;

/**实例内部类:
 * 特点：
 * 1)定义：类的内部，方法外部
 * 2)此类的实例依托于外部类对象
 * 3)允许访问外部类任意成员
 * */
class Outer01{
    int n1;
    int n2;
    class Inner01{
        int n3,n4;
        public void change() {
            n1=100;
        }
    }
}

/**静态内部类:
 * 特点：
 * 1)定义：类的内部，方法外部，使用static修饰
 * 2)此类的实例不依托于外部类对象
 * 3)允许访问外部类任意静态成员
 * */

class Outer02{
    private int s1;
    private static int s2;
    static class Inner02{
        public void out() {
            System.out.println(s2);
        }
    }
}

/**局部内部类:
 * 特点：
 * 1)定义：方法内部
 * 2)此类的实例只能在方法内部构建
 * 3)允许访问外部类任意成员
 * */

class Outer03{
    private int n1=10;
    private static int n2=20;

    public void display() {
        class Inner03{
            public void out() {
                System.out.println(n1);
            }
        }
        new Inner03().out();
    }
    public static void show() {
        class Inner03{
            public void out() {
                System.out.println(n2);
            }
        }
        new Inner03().out();
    }
}
interface IOuter{
    void print();
}
class Outer04{
    public void show() {
        //编译器自动添加final
        final boolean flag=true;
        //内部类(IOuter接口的实现类)
        //因为没有名字，所以可以将其理解为匿名内部类
        IOuter o1=new IOuter() {
            @Override
            public void print() {
                boolean f1=flag;
                System.out.println(flag);
                System.out.println("hello-1");
            }
        };
        o1.print();
        //定义在方法内部的匿名内部类还可以看成是一个局部内部类
        //o2.print();
    }
    IOuter o2=new IOuter() {
        @Override
        public void print() {
            System.out.println("hello-2");
        }
    };
}

public class InnerDemo01 {

    public static void main(String[] args) {
        //实例内部类对象的构建及应用
        Outer01 o1=new Outer01();
        Inner01 i001=o1.new Inner01();
        Inner01 i002=new Outer01()
                .new Inner01();
        i001.change();

        System.out.println(o1.n1);
        //静态内部类对象
        Inner02 io2=new Inner02();
        io2.out();

        //匿名内部类
        Outer04 o4=new Outer04();
        o4.show();
    }
}
