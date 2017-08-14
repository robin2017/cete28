package day01.teacher.part02;

import java.util.Date;
//����(��Ʒ�����ͣ�Ʒ��)
/**�����ࣺ
 * �������η�
 * public:����������е����������
 * default:ֻ�����ڱ�������
 * protected:ֻ�����������
 * private:ֻ���ڱ����ڲ�����
 * ˵����
 * 1)�����ⲿ��ʱֻ��ʹ��public,default(��д)
 * 2)�������г�Աʱ�ĸ����η�������ʹ��.
 * */
/**����*/
public class Elephant extends Animal{
	//�����л��������һЩ����
	public Elephant(String name,Date birthday) {
		super(name,birthday);
	}
	/**��������д*/
	@Override
	public int attack() {
		//����һ�����㷨ȥ����һ������ֵ
		return 5;
	}
}
