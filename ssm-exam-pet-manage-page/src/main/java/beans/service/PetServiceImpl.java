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
		//����IDҪ��������ַ�����Ҳ��������
		//entity.setId(UUID.randomUUID().toString());
		//....
		return petDao.insertObject(entity);
	}
	//@Override
	public Map<String,Object> findObjects(String name,
			Integer pageCurrent) {
		//1.��ѯ��ǰҳ����
		int pageSize=2;//ÿҳ�����ʾ��������
		int startIndex=(pageCurrent-1)*pageSize;
		List<Pet> list=petDao.findObjects(name,startIndex,pageSize);
		//2.��ѯ�ܼ�¼��(�����ܼ�¼�������ҳ��)
		int rowCount=petDao.getRowCounts(name);
		int pageCount=0;
		pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}
		//��װ��ҳ����
		PageObject page=new PageObject();
		page.setRowCount(rowCount);
		page.setPageCount(pageCount);
		page.setPageCurrent(pageCurrent);
		page.setPageSize(2);
		page.setStartIndex(startIndex);
		//3.�����ݷ�װ��map
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
		throw new ServiceException("����ѡ��һ���޸�");
		String[] ids=checkedIds.split(",");
		int rows=petDao.deleteObject(ids);
		return rows;
	}
}
