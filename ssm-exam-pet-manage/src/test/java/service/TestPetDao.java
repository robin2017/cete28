package service;

import beans.dao.PetDao;
import beans.domain.Pet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPetDao {

	ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}
	@Test
	public void testInsertObject() {
		PetDao petDao=(PetDao) 
				ctx.getBean("petDao");
		Pet pet=new Pet();
		pet.setName("pet-a");
		pet.setNote("pet-note-aaaaaaaa");
		int rows=petDao.insertObject(pet);
		Assert.assertEquals(1, rows);
		System.out.println("rows="+rows);
	}
	@Test
	public void getObject(){
		PetDao petDao=(PetDao)ctx.getBean("petDao");
		List<Pet> list=petDao.findObjects();
		System.out.println(list);
	}
	@After
	public void destory() {
		ctx.close();
	}
}
