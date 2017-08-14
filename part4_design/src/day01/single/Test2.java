package day01.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by robin on 2017/8/14.
 */
public class Test2 implements Cloneable{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c=Single.class;
        Constructor<Single> cc=c.getDeclaredConstructor();
        cc.setAccessible(true);
        Single single=(Single)cc.newInstance();
        Single single1=(Single)cc.newInstance();
    }
}

class Single{  //懒加载，非线程安全
    private static Single single=null;
    private Single(){}
    public synchronized static Single getInstance(){
        if(single==null)
            single=new Single();
        return single;
    }
}



class Single2{  //饿加载，线程安全
    private static Single2 single=new Single2();
    private Single2(){}
    public  static Single2 getInstance(){
        return single;
    }
}
