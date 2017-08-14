package day01.homework.jiekou;

/**
 * Created by robin on 2017/7/26.
 */
public class Circle implements GeometricObject {
    protected double radius=1.0;
    public Circle(double radius){this.radius=radius;}
    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}
