package day01.homework.duotai;

/**
 * Created by robin on 2017/7/26.
 */
public class Rectangle extends Shape {
    private int length=1;
    private int width=1;
    public Rectangle(){}
    public Rectangle(int length,int width){
        this.length=length;
        this.width=width;
    }
    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public String toString() {
        return "Rectangle[width="+width+",length="+length+"]";
    }
}
