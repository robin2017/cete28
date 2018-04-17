package day01.teacher.part03;
/**�����ࣺ���಻�ܱ��̳�*/
final class M{}
//class N extends M{}//�����
class K{
	int n1;
	/**ʹ��final����ʵ������
	 * 1)Ҫô����ʱ��ֵ
	 * 2)Ҫô���췽���и�ֵ
	 * ʹ��final���������
	 * 1)Ҫô����ʱ��ֵ
	 * 2)Ҫô��̬������и�ֵ
	 * */
	final int n2;
	final int n3=100;
	static final int n4=100;
	static final int n5;
	public K() {
		n2=10;
		//n3=200; �������ٴθ�ֵ
		//n5=100;����ģ�����ʹ��final���ε�������������ڴ˸�ֵ
	}
	static {
		n5=200;
	}
	/**�˷�����������д*/
	public final void save() {}
	public void change1(final boolean flag) {
		//flag=true;//�������ٴθ�ֵ
		System.out.println(flag);
	}
	public void change2() {
		final char c1='A';
		//c1='B';������
		//c1++;������
		System.out.println(c1);
	}
}
public class FinalDemo01 {
	public static void main(String[] args) {
		K k1=new K();
		k1.change1(false);
	}
}
