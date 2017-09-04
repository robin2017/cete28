package beans.dao;

import beans.domain.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface PetDao extends BaseDao<Pet> {
	List<Pet> findObjects(
			@Param("name") String name,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize
	);
	int getRowCounts(@Param("name") String name);
	int deleteObject(@Param("ids") String[] ids);
}
