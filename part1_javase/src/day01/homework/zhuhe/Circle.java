package day01.homework.zhuhe;

/**
 * Created by robin on 2017/7/26.
 */
public class Circle {
    private Point center=new Point(0,0);
    private double radius=1.0;
    public Circle(){}
    public Circle(int xCenter,int yCenter,double radius){
        this.center=new Point(xCenter,yCenter);
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getCenterX(){
        return center.getX();
    }
    public void setCenterX(int x){
        this.center.setX(x);
    }
    public int getCenterY(){
        return center.getY();
    }
    public void setCenterY(int y){
        this.center.setY(y);
    }
    public int[] getCenterXY(){
        int[] res=new int[2];
        res[0]=this.getCenterX();
        res[1]=this.getCenterY();
        return res;
    }
    public void setCenterXY(int x,int y){
        this.setCenterX(x);
        this.setCenterY(y);
    }
    public String toString(){
        return "Circle[center=("+this.getCenterX()+","+this.getCenterY()+"),radius="+this.getRadius()+"]";
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getCircumference(){
        return Math.PI*2*radius;
    }
    public double distance(Circle another){
        double xx=this.getCenterX()-another.getCenterX();
        double yy=this.getCenterY()-another.getCenterY();
        return Math.sqrt(xx*xx+yy*yy);
    }

    public static void main(String[] args){
        Circle circle=new Circle();
        Circle another=new Circle(3,4,5);
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println(circle.getCircumference());
        System.out.print(circle.distance(another));
    }
}
