package day01;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import static day01.util.PrintUtil.println;
/**
 * Created by robin on 2017/7/26.
 */
public class IceBox {
    private String brand;
    private String code;
    private Collection collection=new ArrayList();
    public void put(Object object){
        println("放进去一个：" + object.getClass().getName());
        Class<?> cla=object.getClass();
        Field[] fields=cla.getFields();
        for(Field field:fields)
            println(field.getName());
        this.collection.add(object);
    }
    public void open(){println("开门");}
    public void close(){println("关门");}
    public void doIce(){println("冷冻");}


    private Tiger tiger;
    private Elephant elephant;
    public void put(Tiger tiger){
        this.tiger=tiger;
    }
    public void put(Elephant elephant){
        this.elephant=elephant;
    }

    private Animal animal;
    public void put(Animal animal){
        this.animal=animal;
    }
}
