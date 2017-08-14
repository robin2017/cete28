package day01.teacher.part02;

import java.util.Date;

/**�ϻ�*/
public class Tiger extends Animal{
	//������д����
   /*
     public Tiger() {
		super();//���ø����޲εĹ��캯��
	 }
    */
	public Tiger(String name,Date birthday) {
		//��ʽ���ø���Ĺ��캯��
		//��ʱĬ�ϵ�super()��û����
		super(name,birthday);
	};
	/**��������д
	 * 1)��д�����ڼ̳й�ϵ��
	 * 2)������Ը��෽������һ�����ǲ���
	 * */
	@Override
	public int attack() {
		//ͨ���㷨�������ϻ��Ĺ���ֵ
		return 100;
	}
}
