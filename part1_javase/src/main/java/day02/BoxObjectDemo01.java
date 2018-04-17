package day02;

/**
 * Created by robin on 2017/7/27.
 */

class IngergerCache{
    static Integer[] cache =new Integer[256];
    static {
        for(int i=0;i<cache.length;i++){
            cache[i]=i-128;
        }
    }
}
public class BoxObjectDemo01 {
    public static void main(String[] args){

        Integer m1=100;//从整数池中取（-128——127）
        Integer m2=100;
        System.out.println(m1==m2);
        Integer m3=200;
        Integer m4=200;
        System.out.println(m3==m4);
//        true
//        false

    }
}
