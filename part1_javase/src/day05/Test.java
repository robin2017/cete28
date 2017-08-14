package day05;

import java.lang.reflect.Field;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by robin on 2017/8/7.
 */
public class Test {
    public static void main(String[] args){

        System.out.println(new Test().getSql(new AA()));

    }
    public String getSql(Object object){
        StringBuffer fieldsName=new StringBuffer();

        Class<?>  c=object.getClass();
        String className=c.getSimpleName();
        Field[] fields=c.getDeclaredFields();
        for(Field field:fields){

            fieldsName.append(field.getName()+",");
        }
        return "insert into "+className+"("+fieldsName.toString()+")value(?,?)";
    }

    public String getSqlO(Object object){
         Class c=object.getClass();
        String className=c.getSimpleName();
        StringBuffer s=new StringBuffer();
        s.append("insert into ").append(className).append("(");
        Field[] fields=c.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            s=i==0?s.append(fields[i].getName()):s.append(",").append(fields[i].getName());
        }
        s.append(") values").append(getString(fields.length));
                return s.toString();
    }

    public static String getString(int length){
        StringBuffer stringBuffer=new StringBuffer();
        return null;

    }
    private Lock lock=new ReentrantLock();
    public void test(){
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }
}

class AA{
    public int namg;
    public int age;

}