package day01.teacher.part03;

class ClassA{}//������
abstract class ClassB{}//������(������ʹ��final����)
abstract class ClassC{//�����еİ��Ʒ
	abstract void method01();
	void method02() {}
}

public class AbstractClassDemo01 {

	public static void main(String[] args) {
		new ClassA();
		//new ClassB();//����
	}
}
