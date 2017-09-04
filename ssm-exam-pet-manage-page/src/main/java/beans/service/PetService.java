package beans.service;
import java.util.Map;

import beans.domain.Pet;
public interface PetService {
	int saveObject(Pet entity);
	Map<String,Object> findObjects(String name, Integer pageCurrent);
    int deleteObject(String checkedIds);
}
