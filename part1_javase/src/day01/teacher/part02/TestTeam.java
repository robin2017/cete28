package day01.teacher.part02;

import java.util.Date;

public class TestTeam {

	public static void main(String[] args) {
		//������������
		Elephant e1=
	    new Elephant("elephant-01",new Date());
		Tiger t1=
		new Tiger("tiger-01",new Date());
		//��Team����
		Team team=new Team("�Ͼ�28��");
		
		team.put(e1);//put(Animal a);a-->Elephant
		team.put(t1);//put(Animal a);a-->tiger;
		team.setName("�Ͼ�28��Javaս��");
		//����Team�ŶӵĹ���ֵ
		int totalAttack=team.doAttack();
		System.out.println("totalAttack="+
		totalAttack);
	}
}
