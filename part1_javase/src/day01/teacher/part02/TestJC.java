package day01.teacher.part02;
class A{
	void method1() {
		System.out.println("A-method-1");
	}
	void method2() {
		System.out.println("A-method-2");
	}
}
class B extends A{
	@Override
	void method1() {
		System.out.println("B-method-1");
	}
	
	void method3() {
		System.out.println("B-method-3");
	}
}
class C extends B{}//������̳�
class D{}
//class E extends D,A{};//����

class H{
	public H() {
		System.out.println("H");
	}
}
class K{
	public K() {
		System.out.println("K");
	}
}
class M{
	H h=new H();
	public M() {
		System.out.println("M()");
	}
}
class N extends M{
	K k=new K();
	public N() {
		System.out.println("N()");
	}
}
public class TestJC {
     public static void main(String[] args) {
		 A a=new A();//A-method-1
		 a.method1();
    	 B b=new B();
		 b.method1();//B-method-1
		 //�������ÿ���ָ���������(����ת��)
		 a=new B();//����ʱ������(�Ⱥ����)
		 a.method1();//B-method-1
		 a.method2();//A-method-2;
		 //a.method3();���󣬵�����
		 //�ж�aָ��Ķ��������
		 if(a instanceof B) {//��B������᷵��true
			 //��ʱ���Խ�aǿת��B���ͣ�Ȼ���ٽ��е���
			 //����ת��
			 ((B)a).method3();
		 }
		 //���ϻ�����ֻ�ܷ����ڼ̳й�ϵ��
		 //�ֵ�֮�䲻��ת��
		 
		 //M m=new M();
		 
		 N n=new N();
		 
	}
}
