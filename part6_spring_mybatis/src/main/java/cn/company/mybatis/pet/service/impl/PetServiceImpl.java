package cn.company.mybatis.pet.service.impl;

import cn.company.mybatis.pet.dao.PetDao;
import cn.company.mybatis.pet.domain.Pet;
import cn.company.mybatis.pet.service.PetService;
import cn.company.mybatis.pet.utils.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetServiceImpl implements PetService{
	public static void main(String[] args) {
		List<Pet> list=new PetServiceImpl().findObjects();

		for (int i = 0; i <list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}
	public List<Pet> findObjects() {
		SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSession();
		PetDao projectDao=(PetDao)
		sqlSession.getMapper(PetDao.class);
		try {
		return projectDao.findObjects();
		}finally {
			sqlSession.close();
		}
	}

	public Pet findObjectById(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			PetDao projectDao = 
			sqlSession.getMapper(PetDao.class);
			return projectDao.findObjectById(id);
		} finally {
			sqlSession.close();
		}
	}

	public void saveObject(Pet entity) {
		SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSession();
		try {
		PetDao projectDao=
		sqlSession.getMapper(PetDao.class);
		projectDao.insertObject(entity);
		sqlSession.commit();
		}finally {
		sqlSession.close();
		}
	}

	public void updateObject(Pet entity) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			PetDao projectDao = 
			sqlSession.getMapper(PetDao.class);
			projectDao.updateObject(entity);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	public void deleteObject(Integer id) {
		SqlSession sqlSession = 
		MyBatisSqlSessionFactory.getSqlSession();
		try {
			PetDao projectDao = 
			sqlSession.getMapper(PetDao.class);
			projectDao.deleteObject(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}

