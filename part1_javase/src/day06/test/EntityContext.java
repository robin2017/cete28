package day06.test;

import java.io.*;
import java.util.HashMap;

/**
 * Created by robin on 2017/8/8.
 */
public class EntityContext {
    private HashMap<Integer,User> users=new HashMap<Integer, User>();
    public EntityContext(){
        try {
            users=getUsers("user.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        HashMap<Integer, User> hashMap=new EntityContext().getUsers("user.txt");
    }
    public  HashMap<Integer,User> getUsers(String filename) throws IOException {
        HashMap<Integer,User> hashMap=new HashMap<Integer, User>();
        BufferedReader in=new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
        String s;
        while((s=in.readLine())!=null){
            String[] arr=s.split(":");
            User user=new User();
            user.setId(Integer.parseInt(arr[0]));
            user.setName(arr[1]);
            user.setPassword((arr[2]));
            user.setMail(arr[3]);
            hashMap.put(user.getId(),user);
        }
        return hashMap;
    }
}

