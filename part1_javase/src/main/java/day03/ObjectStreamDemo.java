package day03;

import java.io.*;

/**
 * Created by robin on 2017/7/28.
 */
class Point implements Serializable{
    int x;
    int y;
    //序列化只保存成元变量，不保存成员方法，所以序列化中没有加密方法，别人就不知道加密算法了
    private void writeObject(ObjectOutputStream outputStream) throws IOException, ClassNotFoundException {
        x=x+2;
        outputStream.defaultWriteObject();
    }
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        x=x-2;
        inputStream.defaultReadObject();
    }
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Point point=new Point(8,20);
        System.out.println(point);
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("o1.txt"));
        outputStream.writeObject(point);
        outputStream.close();

        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("o1.txt"));
        Point point1=(Point)inputStream.readObject();
        inputStream.close();
        System.out.println(point1.x);
    }
}
