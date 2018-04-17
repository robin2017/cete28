package day06.ServerTest;

/**
 * Created by robin on 2017/8/8.
 */
public class Hello {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        a.a = 2;
        b.a = 2;
        System.out.println(a.equals(b));

        String s1="hello"+"world";
        String s2="helloworld";
        System.out.println(s2==s1);//true
    }
}
class A {
    int a;
    public boolean equals(A obj) {
        return this.a == obj.a;
    }
}