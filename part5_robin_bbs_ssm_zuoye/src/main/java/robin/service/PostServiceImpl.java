package robin.service;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import robin.dao.PostDao;
import robin.domain.Post;
import robin.utils.MyBatisSqlSessionFactory;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
	public static void main(String[] args) {
		List<Post> list=new PostServiceImpl().findObjects();

		for (int i = 0; i <list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}
	public List<Post> findObjects() {
		SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSession();
		PostDao projectDao=(PostDao)
		sqlSession.getMapper(PostDao.class);
		try {
		return projectDao.findObjects();
		}finally {
			sqlSession.close();
		}
	}

	public Post findObjectById(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			PostDao projectDao =
			sqlSession.getMapper(PostDao.class);
			return projectDao.findObjectById(id);
		} finally {
			sqlSession.close();
		}
	}

	public void saveObject(Post entity) {
		SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSession();
		try {
			PostDao projectDao=
		sqlSession.getMapper(PostDao.class);
		projectDao.insertObject(entity);
		sqlSession.commit();
		}finally {
		sqlSession.close();
		}
	}

	public void updateObject(Post entity) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			PostDao projectDao =
			sqlSession.getMapper(PostDao.class);
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
			PostDao projectDao =
			sqlSession.getMapper(PostDao.class);
			projectDao.deleteObject(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}

