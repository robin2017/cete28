package cn.company.mybatis.pet.service;
import cn.company.mybatis.pet.domain.Pet;

import java.util.List;

public interface PetService {
	List<Pet> findObjects();
	Pet findObjectById(Integer id);
	void saveObject(Pet entity);
	void updateObject(Pet entity);
	void deleteObject(Integer id);
}
