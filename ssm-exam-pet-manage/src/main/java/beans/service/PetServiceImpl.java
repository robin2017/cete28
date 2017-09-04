package beans.service;
import beans.dao.PetDao;
import beans.domain.Pet;
import beans.web.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PetServiceImpl implements PetService {
	public static void main(String[] args) {
		List<Pet> list=new PetServiceImpl().findObjects();
		System.out.println(list);
	}
	@Autowired
	private PetDao petDao;
	//@Override
	public int saveObject(Pet entity) {
		//假如ID要求是随机字符串，也可以这样
		//entity.setId(UUID.randomUUID().toString());
		//....
		return petDao.insertObject(entity);
	}
	//@Override
	public List<Pet> findObjects() {
		return petDao.findObjects();
	}
	//@Override
	public List<Pet> findObjects(String name) {
		if(name==null||name.trim().length()==0)
	    throw new ServiceException("查询参数不能为空");
		//访问数据库
		return new ArrayList<Pet>(petDao.findObjectsByName(name));
	}
}
