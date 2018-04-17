package day02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by robin on 2017/7/27.
 */
public class SringBuilder01 {
    public static void main(String[] args){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("a").append("b").append("c");

        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(7);
        System.out.println(Arrays.toString(arrayList.toArray()));

        String s3;
    }
}
