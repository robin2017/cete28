package day06.ServerTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by robin on 2017/8/9.
 */
public class HHH {
    private static Properties p=new Properties();
    static {
        try {
            p.load(Cache.class.getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        System.out.println(p.get("root"));

    }
}


class Cache{
    private HashMap hashMap=new HashMap();
    Class c;
    private ReentrantReadWriteLock rrwl=new ReentrantReadWriteLock();
    private Object value;
    public Object get(Object key){
        rrwl.readLock().lock();
        value= hashMap.get(value);

        if(value==null){
            rrwl.readLock().unlock();
            rrwl.writeLock().lock();
            if(value==null) {
                //模拟后台获取或者创建
                value = "...";
                hashMap.put(key, value);
            }
            rrwl.writeLock().unlock();
            rrwl.readLock().lock();
        }
        rrwl.readLock().unlock();
        return value;
    }
}