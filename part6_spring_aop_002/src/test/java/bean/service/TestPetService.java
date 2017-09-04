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
		//获得petServiceImpl对象的一个代理对象
		PetService petService=
		(PetService) 
		ctx.getBean("petServiceImpl");
		//执行代理对象的方法
		//petService.saveObject();
		petService.updateObject();
		//底层会自动调用目标对象中的业务方法
	}
	@After
	public void close() {
		ctx.close();
	}
}
