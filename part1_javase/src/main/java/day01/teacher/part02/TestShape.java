package day01.teacher.part02;
class Point{
	private int x;
	private int y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
 class Line{
	private Point p1;
	private Point p2;
	public Line(Point p1,Point p2) {
		this.p1=p1;
		this.p2=p2;
	}
	/**���ߵĳ���*/
	public double length() {
		int x=p1.getX()-p2.getX();
		int y=(p1.getY()-p2.getY());
		return Math.sqrt(x*x+y*y);
	}
}
 
class Circle{
	private Point point;//null
	private int r;
	public Circle(Point point,int r) {
		this.point=point;
		this.r=r;
	}
	/**�����*/
	public double getArea() {
		return Math.PI*r*r;
	}
	public double getLength() {
		return 2*Math.PI*r;
	}
	public double distance(Circle c) {
		int a=this.point.getX()-c.point.getX();
		int b=this.point.getY()-c.point.getY();
		return Math.sqrt(a*a+b*b);
	}
}
/**����һ��Բ��*/
class Cylinder extends Circle{
	/**����Բ���ĸ߶�*/
	private int height;
	public Cylinder(Point p1,int r,int height) {
		super(p1,r);//���ʸ��๹�캯��
		this.height=height;
	}
	/**��д�����getArea����*/
	@Override
	public double getArea() {
		double cArea1=
		2*super.getArea();
		double cArea2=
		super.getLength()*height;
		return cArea1+cArea2;
	}
	/**�����*/
	public double getVolume() {
		return super.getArea()*height;
	}
}
public class TestShape {

	public static void main(String[] args) {
		Point p1=new Point(2,5);
		Circle c1=new Circle(p1,10);
		
		Point p2=new Point(5,9);
		Circle c2=new Circle(p2,20);
		
		double distance=
		c1.distance(c2);
		System.out.println(distance);
		
		Circle c3=new Circle(p2, 20);
		c3.getArea();
		c3=new Cylinder(p1, 10, 20);
		c3.getArea();//��̬����
		
	}
}
