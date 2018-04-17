package day05.homework.title2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by robin on 2017/8/7.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        List<String> list=readline("file.txt");
        TreeMap<String,Integer> treeMap=new TreeMap<String, Integer>();
        for(int i=0;i<list.size();i++){
            String[] arr=list.get(i).split(",");
            if(treeMap.get(arr[1])==null)
                treeMap.put(arr[1],1);
            else
                treeMap.put(arr[1],treeMap.get(arr[1])+1);
        }
        for(String str:treeMap.keySet()){
            System.out.println(str);
        }

    }
    public static List<String> readline(String filename) throws IOException {
        List<String> list=new ArrayList<String>();
        BufferedReader in=new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
        String s;
        while((s=in.readLine())!=null){
            list.add(s);
        }
        return  list;
    }

    public HashMap<String,Integer> getMap() throws IOException {
        BufferedReader bufferedReader=
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File("file.txt"))));
        String str=null;
        while((str=bufferedReader.readLine())!=null){

        }
        return null;
    }
}
