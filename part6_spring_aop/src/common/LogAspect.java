package common;
/**��spring�Ὣ������һ��������Ϊ����*/
public class LogAspect {
	/**��spring�лὫ������һ����������Ϊ
	 * ��չҵ���е�һ�����裬�������spring
	 * �������֮Ϊ֪ͨ�������֪ͨ��ͨ��
	 * ����ķ�ʽ����ֲ�뵽��������ִ�еĹ�����*/
	public void before() {
		System.out.println("method.start");
	}
	public void afterReturn() {
		System.out.println("method.end");
	}
}
