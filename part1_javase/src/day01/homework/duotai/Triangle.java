package day01.homework.duotai;

/**
 * Created by robin on 2017/7/26.
 */
public class Triangle extends Shape {
    private int base=1;
    private int height=1;
    public Triangle(){}
    public Triangle(int base,int height){
        this.base=base;
        this.height=height;
    }
    @Override
    public double getArea() {
        return 0.5*base*height;
    }

    @Override
    public String toString() {
        return "Trangle[bas="+base+",height="+height+"]";
    }
}
