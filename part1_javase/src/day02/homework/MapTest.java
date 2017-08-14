package day02.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by robin on 2017/7/28.
 */
public class MapTest {
    private static String string="hi, good study, day day up";
    public static void main(String[] args){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map=getNumber(string);
        System.out.println(map);

    }
    public static Map<String,Integer> getNumber(String string){
        String[] arr=string.split("");
        Map<String,Integer> map= new HashMap<String,Integer>();
        for(String str:arr){
            if(!(('a'<=str.charAt(0)&&str.charAt(0)<='z')||('A'<=str.charAt(0)&&str.charAt(0)<='Z')))
                continue;
            if(map.containsKey(str))
                map.put(str,map.get(str)+1);
            else
                map.put(str,1);
        }
        return map;
    }
}
