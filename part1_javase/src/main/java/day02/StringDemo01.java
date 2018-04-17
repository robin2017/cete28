package day02;

/**
 * Created by robin on 2017/7/27.
 */
public class StringDemo01 {
    public static void main(String[] args){
        Integer integer;

        String s1="hello";//常量池中
        String s2="hello";
        System.out.println(s1==s2);
        String s3=new String("a");
        String s4=new String("a");
        System.out.println(s3==s4);
//        true
//        false

        String s5="abc";
        String s6="de";
        String s7=s5+s6;//字符串连接（new String())）
        String s8="abc"+"de";  //编译器自动优化，存储到字符串池
        System.out.println(s7==s8);
//        false
    }
}
