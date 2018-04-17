package day01.teacher.part03;
class A{
	/**�����(�������ж�����)*/
	static int count1;
	/**��̬�����(�����ʱִ��)
	 * 1)ͨ�������������г�ʼ����ֵ
	 * 2)ֻ�ܷ��ʱ���ľ�̬��Ա
	 * */
	static {
		count1++;
	}
	/**ʵ������飬���󹹽�ʱִ��*/
	{
	  	System.out.println("{}");
	}
	/**ʵ������(ÿ��������һ��)*/
	int count2;
	/**���췽���ڹ�������ʱ����*/
	public A(){
		count1++;
		count2++;
	}
	/**��̬������
	 * 1)ʹ��static����
	 * 2)����ֱ�ӵ���
	 * 3)ֻ�ܷ��ʱ��ྲ̬��Ա
	 * */
	public static void print(){
		System.out.println("A.print.count1="+count1);
		//System.out.println(count2);
	}
}
class B extends A{
	/**��̬����������д����û�ж�̬��һ��Ҳ������ô��*/
	public static void print(){
		System.out.println("B.print");
	}
}

public class StaticDemo01 {
	public static void main(String[] args) {
		//System.out.println(A.count1);
		//System.out.println(A.count2); ����
	    A a1=new A();
	    A a2=new A();
	    System.out.println(a2.count2);//1
	    //System.out.println(A.count1);//3
	    //A.print();
	    A a3=new B();
	    a3.print();//���Ƿ���A��print����
	    
	}
}
