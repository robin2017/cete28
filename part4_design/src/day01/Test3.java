package day01;

import java.io.*;
import java.lang.ref.SoftReference;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by robin on 2017/8/14.
 */
public class Test3 {
    public static void main(String[] args) throws IOException {

        FilterOutputStream filterOutputStream;
        FileOutputStream out=new FileOutputStream("a");
        out.write(1000);//每次只能读写1个字节，不能写整数

        DataOutputStream dout=new DataOutputStream(out);
        dout.writeInt(1000);//可以写一个整数

        byte[] bytes=null;
        BufferedOutputStream bdout=new BufferedOutputStream(dout);
        bdout.write(bytes);

    }

    public void est() throws IOException {

        Socket socket=new Socket();
        new BufferedReader(//装饰器模式，提高功能
                new InputStreamReader(//适配器模式，转化类型
                        new FileInputStream("dd")));

        new BufferedReader(//装饰器模式，提高功能
                new InputStreamReader(//适配器模式，转化类型
                        System.in));

        new BufferedReader(//装饰器模式，提高功能
                new InputStreamReader(//适配器模式，转化类型
                        socket.getInputStream()));

    }

    public void tt() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o);
        o = null;

        //软引用对象获取
        Object oo=softReference.get();
    }


}

class Cache{
    private Object value;
    private HashMap hashMap=new HashMap();
    public Object get(Object key){
        value= hashMap.get(key);
        if(value==null){
            value="...";
            hashMap.put(key,value);
        }
        return value;
    }
}