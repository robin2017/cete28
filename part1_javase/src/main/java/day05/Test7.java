package day05;

import java.lang.reflect.Field;

/**
 * Created by robin on 2017/8/7.
 */
public class Test7 {
    public static void main(String[] args) throws IllegalAccessException {
        Student student=new Student();
        student.setName("robin");
        student.setNumber(100);
        changeValue1(student);
        System.out.println(student);

    }
    public static void changeValue(Object obj) throws IllegalAccessException {
        Class c=obj.getClass();
        Field[] fields=c.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            String fieldName=field.getName();
            String fieldType =field.getType().getSimpleName();
           // System.out.println(fieldType);
            if(fieldType.equals("String")){
                String value=(String)field.get(obj);
                field.set(obj,value.toUpperCase());
            }else if(fieldType.equals("int")){
                int value=(Integer)field.get(obj);
                field.set(obj,value+100);
            }
        }
    }

    public static void changeValue1(Object obj)
            throws IllegalAccessException {
        Class c=obj.getClass();
        Field[] fields=c.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            if(field.getType()==String.class){
                String value=(String)field.get(obj);
                field.set(obj,value.toUpperCase());
            }else if(field.getType()==int.class){
                int value=field.getInt(obj);
                field.set(obj,value+100);
            }
        }
    }




}

class Student {
    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}