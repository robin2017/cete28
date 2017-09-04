package beans.service;
import beans.dao.PetDao;
import beans.domain.Pet;
import beans.web.PageObject;
import beans.web.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PetServiceImpl implements PetService {
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
	public Map<String,Object> findObjects(String name,
			Integer pageCurrent) {
		//1.查询当前页数据
		int pageSize=2;//每页最多显示几条数据
		int startIndex=(pageCurrent-1)*pageSize;
		List<Pet> list=petDao.findObjects(name,startIndex,pageSize);
		//2.查询总记录数(根据总记录数获得总页数)
		int rowCount=petDao.getRowCounts(name);
		int pageCount=0;
		pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}
		//封装分页数据
		PageObject page=new PageObject();
		page.setRowCount(rowCount);
		page.setPageCount(pageCount);
		page.setPageCurrent(pageCurrent);
		page.setPageSize(2);
		page.setStartIndex(startIndex);
		//3.将数据封装到map
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", page);
		return map;
	}
	/**
	 * checkedIds="1,2,3,4"
	 */
	//@Override
	public int deleteObject(String checkedIds) {
		if(checkedIds==null||checkedIds.trim().length()==0) 
		throw new ServiceException("至少选择一个修改");
		String[] ids=checkedIds.split(",");
		int rows=petDao.deleteObject(ids);
		return rows;
	}
}
