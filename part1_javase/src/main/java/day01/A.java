package day01;

/**
 * Created by robin on 2017/7/26.
 */
public class A {
    static int count1;
    static {
        count1++;
    }
    int count2;
    public A(){
        count2++;
    }
    public static void main(String[] args){
        A a1=new A();
        A a2=new A();


    }
}
