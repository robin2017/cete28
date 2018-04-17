package day01.teacher.part02;

public class Team {
	
/*	private Elephant elephant;
	private Tiger tiger;
	public void put(Elephant e) {
		this.elephant=e;
	}
	public void put(Tiger t) {
		this.tiger=t;
	}*/
	
	private String name;
	public Team(String name) {
		this.name=name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**�����Ϳ���ָ�����������
	 * Animal a1=new Tiger();
	 * Animal a2=new Elephant();
	 * */
	private Animal[] animals=new Animal[2];
	//ͨ���˱�����¼�������ĸ���
	private int size;
	//������ʱanimal����ָ������ĸ�����
	//�ͻ�����ĸ������getName����
	public void put(Animal animal) {
		if(size==animals.length) {
			System.out.println("�Ŷ��Ѿ���Ա");
			return;
		}
		animals[size]=animal;
		size++;
		System.out.println(
		animal.getName()+"�����Ŷ�");
	}
	/**�����Ŷӵ��ܵĹ���ֵ*/
	public int doAttack() {
		 int totalAttack=0;
	     for(int i=0;i<size;i++) {
	    	 totalAttack+=
	    	 //����ʱ������,����ʱ������
	    	 animals[i].attack();
	     }
	     return totalAttack;
	}
}
