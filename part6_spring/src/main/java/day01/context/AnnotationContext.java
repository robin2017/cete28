package day01.context;

/**
 * Created by robin on 2017/8/19.
 */


import day01.beans.Component;
import day01.beans.PageObject;
import day01.beans.Value;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;




public class AnnotationContext {
    static Map<String,Object> objBeanMap=
            new HashMap<String,Object>();
    public static void main(String[] args)throws Exception {
        Class<?> c1=PageObject.class;
        boolean flag=
                c1.isAnnotationPresent(Component.class);
        if(flag) {
            String className=c1.getSimpleName();
            String first=className.substring(0, 1).toLowerCase();
            String key=className.replaceFirst("\\w", first);

            Object obj=c1.newInstance();
            Field[] fs=c1.getDeclaredFields();
            for(Field f:fs) {
                if(f.isAnnotationPresent(Value.class)) {
                    Value v=f.getAnnotation(Value.class);
                    String fValue=v.value();
                    f.setAccessible(true);
                    f.set(obj, Integer.valueOf(fValue));
                }
            }
            objBeanMap.put(key, obj);
        }
        System.out.println(objBeanMap);

    }
}

