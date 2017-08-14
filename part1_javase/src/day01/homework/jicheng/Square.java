package day01.homework.jicheng;

/**
 * Created by robin on 2017/7/26.
 */
public class Square extends Rectangle{
    public Square(){
    }
    public Square(double side){
        super.setWidth(side);
        super.setLength(side);
    }
    public Square(double side,String color,boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){
        return super.getLength();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }
    public void setWidth(double side){
        super.setWidth(side);
    }
    public void setLength(double side){
        super.setLength(side);
    }
    public String toString(){
        return "Square[side="+super.getLength()+"]";
    }
}
