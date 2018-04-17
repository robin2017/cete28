//package day03;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
///**
// * Created by robin on 2017/7/28.
// */
//public class ExceptionDemo {
//    public static void main(String[] args){
//
//
//        FileOutputStream fileOutputStream=null;
//        try {
//            fileOutputStream=new FileOutputStream("dd");
//            return ;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }finally {
//            int b=0;
//        }
//    }
//
//
//    static int method(){
//        int  a=10;
//        try{
//        if(a==20)throw new Exception("exception");
//        a+=10;
//        return a;
//            catch()
//
//    }
//}
