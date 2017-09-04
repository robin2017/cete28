package blog.service.impl;

import blog.dao.BlogDao;
import blog.domain.Blog;
import blog.service.BlogService;
import blog.utils.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by robin on 2017/8/23.
 */
@Service
public class BlogServiceImpl implements BlogService {

    //单元测试
    public static void main(String[] args) {
        List<Blog> list=new BlogServiceImpl().findObjectsByName("sa");

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
    public List<Blog> findObjects() {
        SqlSession sqlSession= MyBatisSqlSessionFactory.getSqlSession();
        BlogDao projectDao=(BlogDao)
                sqlSession.getMapper(BlogDao.class);
        try {
            return projectDao.findObjects();
        }finally {
            sqlSession.close();
        }
    }

    public Blog findObjectById(Integer id) {

        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            BlogDao projectDao =
                    sqlSession.getMapper(BlogDao.class);
            return projectDao.findObjectById(id);
        } finally {
            sqlSession.close();
        }
    }

    public Integer insertObject(Blog project) {
        SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSession();
        int result=0;
        try {
            BlogDao projectDao=
                    sqlSession.getMapper(BlogDao.class);
           result= projectDao.insertObject(project);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }



    public Integer updateObject(Blog entity) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        int result=0;
        try {
            BlogDao projectDao =
                    sqlSession.getMapper(BlogDao.class);
           result =projectDao.updateObject(entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return result;
    }
    public Integer deleteObject(Integer id) {
        SqlSession sqlSession =
                MyBatisSqlSessionFactory.getSqlSession();
        int result=0;
        try {
            BlogDao projectDao =
                    sqlSession.getMapper(BlogDao.class);
           result= projectDao.deleteObject(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public List<Blog> findObjectsByName(String name) {
        SqlSession sqlSession= MyBatisSqlSessionFactory.getSqlSession();
        BlogDao projectDao=(BlogDao)
                sqlSession.getMapper(BlogDao.class);
        try {
            return projectDao.findObjectsByName(name);
        }finally {
            sqlSession.close();
        }
    }
}
