package cn.company.mybatis.pet.dao;
import cn.company.mybatis.pet.domain.Pet;

import java.util.List;
/**�Ŀ��Ϣdao*/
public interface PetDao {
	List<Pet> findObjects();
	Pet findObjectById(Integer id);
	Integer insertObject(Pet project);
	Integer updateObject(Pet project);
	Integer deleteObject(Integer id);
}
