package beans.dao;

import beans.domain.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface PetDao {
	int insertObject(Pet entity);
	List<Pet> findObjects();
	List<Pet> findObjectsByName(
			@Param("name") String name);
}
