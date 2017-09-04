package mapper;

import cn.company.mybatis.pet.domain.Pet;
import cn.company.mybatis.pet.service.PetService;
import cn.company.mybatis.pet.service.impl.PetServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestPetService {
	private PetService petService;
	@Before
	public void onCreate() {
		petService = new PetServiceImpl();
	}
	@Test
	public void testSaveObject() {
		Pet entity=new Pet();
		entity.setId(2);
		entity.setName("pet-B");
		entity.setCode("pet002");
		entity.setBirthday(new Date());
		entity.setNote("pet-b-note");
		petService.saveObject(entity);
	}
	@Test
	public void testUpdateObject(){
		Pet pet=
		petService.findObjectById(18);
		pet.setName("pet-a-01");
		petService.updateObject(pet);
	}
	@Test
	public void testDeleteObject() {
		petService.deleteObject(18);
	}
	@Test
	public void testFindObjectById() {
		Pet pet=petService.findObjectById(1);
		System.out.println(pet);
		pet=petService.findObjectById(1);
		System.out.println(pet);
	}
	@Test
	public void testFindObjects() {
		List<Pet> list=petService.findObjects();
		System.out.println(list);
	}
	@After
	public void onDestory() {
		petService=null;
	}
}
