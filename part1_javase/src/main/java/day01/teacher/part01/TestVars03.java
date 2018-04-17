package day01.teacher.part01;

class Student{
	int code;//ѧ��,Ĭ��ֵΪ0
}
public class TestVars03 {
	public static void main(String[] args) {
		Student s1=new Student();
		//s2��¼�ڶ���student�����ڶ��ڴ�ĵ�ַ
		Student s2=new Student();
		s1.code=1001;
		System.out.println(s2.code);//0
		change(s2);//����ַ(s3=s2,��ʱs3Ҳָ��s2ָ��Ķ���)
		System.out.println(s2.code);//1002
	}
	public static void change(Student s3) {
		s3.code=1002;
	}
}
