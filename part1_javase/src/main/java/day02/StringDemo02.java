package day02;

import java.util.UUID;

/**
 * Created by robin on 2017/7/27.
 */
public class StringDemo02 {
    public static void main(String[] args){
        String s1="abcdef中国";//字符数
        int len1=s1.length();
        System.out.println("len1:"+len1);
        byte buf[]=s1.getBytes();//字节数
        int len2=buf.length;
        System.out.println("len2:"+len2);
//        len1:8
//        len2:12
        String s3= UUID.randomUUID().toString();
        System.out.println(s3);
        //141a6814-4987-4dbf-b7db-cc1b99ec651d
    }
}
