package bean.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.service.PetService;

public class TestPetService {

	private ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx=
		new ClassPathXmlApplicationContext("spring-aop.xml");
	}
	@Test
	public void testService() {
		//���petServiceImpl�����һ���������
		PetService petService=
		(PetService) 
		ctx.getBean("petServiceImpl");
		//ִ�д������ķ���
		//petService.saveObject();
		petService.updateObject();
		//�ײ���Զ�����Ŀ������е�ҵ�񷽷�
	}
	@After
	public void close() {
		ctx.close();
	}
}
