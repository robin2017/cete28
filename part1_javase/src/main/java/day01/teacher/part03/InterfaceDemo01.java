package day01.teacher.part03;

interface IA{
	public static final int n1=100;
	void show();//Ĭ�϶��ǳ���ĵ�
}//���ͳ���֮�����ϣ��ṩ�Ŀ���չ�ԡ�
interface IC extends IA{}
interface ID extends IC{}//���
interface IB{}
interface IE extends ID,IB{}//����
class ClassA1 implements IA{
	@Override
	public void show() {}
}
abstract class ClassA2 implements IA{}
public interface InterfaceDemo01 {

//	public static void main(String[] args) {
//		IA a1=new ClassA1();
//		ClassA1 a2=new ClassA1();
//		a1=a2;
//	}
}
