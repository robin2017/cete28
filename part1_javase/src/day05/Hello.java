package day05;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robin on 2017/8/7.
 */
public class Hello {
    public static void main(String[] args){
        B b=new B();
        test1();
    }


    public static void test1(){
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("aa");
        arrayList.add("bb");
     //   arrayList.add(3,"cc");  //IndexOutOfBoundsException  Index: 3, Size: 2
        HashMap hashMap;
        HashSet hashSet;


        String s="ab中国";
        try {
            byte[] bytes1=s.getBytes("gbk");
            byte[] bytes2=s.getBytes("utf-8");
            System.out.println(new String(bytes1));//ab�й�
            System.out.println(new String(bytes2));//ab中国

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}


class A{
    public A(){
        test();
    }
    public void test(){
        System.out.println("hello");
    }
}
class  B extends A{
    private int i;
    {
        i=11;
    }
    public void test(){
        System.out.println("world"+i);
    }
}
