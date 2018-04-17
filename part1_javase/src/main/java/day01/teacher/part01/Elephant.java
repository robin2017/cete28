package day01.teacher.part01;

import java.util.Date;

/**����һ����������
 * ����ʲô��
 * 1)���������
 * 2)����ĳ���
 * 3)�Ǵ��������ģ��
 */
public class Elephant {//����(����),��Ϊ(����)
	/**���ԣ�����*/
	String name;//null
	/**��������*/
	Date birthday;//null
	public Elephant() {//new Elephant();
		//this("Сe",new Date());
	}
	/**���췽����
	 * 1)������������ͬ
	 * 2)û�з���ֵ����
	 * 3)��������ʱ����
	 * 4)ͨ�����ڶ����Գ�ʼ��
	 * ˵����ÿ���඼��Ĭ����һ���޲εĹ��캯����
	 * �����Լ������˴������Ĺ��캯�����Ǹ��޲���
	 * ���캯����û�У���ʱ������Ҫ�����Լ����塣
	 * 
	 * this:�൱��һ��������Զָ��ǰ����
	 * 1)this(...);ֻ��Ӧ���ڹ��췽���У�
	 *   ���ʱ����������캯��������ֻ�ܷ��ڵ�һ��.
	 * 2)this.ʵ��������ʵ������
	 * */
	public Elephant(String name,
			Date birthday) {
		this(birthday);//���ñ��๹�캯��
		this.name=name;
		//this.birthday=birthday;
	}
	public Elephant(Date birthday,
			String name) {
		this(birthday);//���ñ��๹�캯��
		this.name=name;
		//this.birthday=birthday;
	}
	public Elephant(Date birthday){
		this.birthday=birthday;
	}
	/**��Ϊ�������ƶ�*/
	public void moveLeft() {
		
	}
	public void moveRight() {}
	//......
}







