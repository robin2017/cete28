package beans.service;
import java.util.List;

import beans.domain.Pet;
public interface PetService {
	int saveObject(Pet entity);
	List<Pet> findObjects();
	List<Pet> findObjects(String name);
}
