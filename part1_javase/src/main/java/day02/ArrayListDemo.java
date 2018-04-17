package day02;

import java.util.ArrayList;

/**
 * Created by robin on 2017/7/27.
 */
public class ArrayListDemo {
    public static void main(String[] args){
        ArrayList arrayList=new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        System.out.println(arrayList);

        for(int i=arrayList.size();i>=0;i--){
            arrayList.remove(0);
        }



    }
}
