package day01.teacher.part01;

import java.util.Date;

/**
 * ֪ʶ��:
 * 1.�������ĸ���
 * 1)��
 * 2)����
 * 2.�������Ĵ���
 * 
 * 
 * @author pjy
 *
 */
public class ElephantBoxClient {
    //���:���ݽṹ+�㷨
	//��������̣����нṹ�������㷨
	public static void main(String[] args) {
		//1.�����������
		
		//Elephant e1=new Elephant();
		Elephant e1=
		new Elephant("EA",new Date());
		//2.�����������
		IceBox box1=new IceBox();
		//3.������ű���
		box1.open();
		box1.put(e1);
		box1.close();
		box1.ice();
	}
}
