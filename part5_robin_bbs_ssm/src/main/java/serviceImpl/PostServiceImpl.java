package serviceImpl;

import dao.PostDao;
import entity.Post;
import org.apache.ibatis.session.SqlSession;
import service.BeanService;
import service.PostService;
import utils.MyBatisSqlSessionFactory;

import java.util.List;

/**
 * Created by robin on 2017/8/22.
 */
public class PostServiceImpl implements PostService {
    public static void main(String[] args) {
        BeanService<Post> postService=new BeanServiceImpl<Post>();
        Class c=postService.getClass();
        List<Post> list=new PostServiceImpl().findAllPosts();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
    public List<Post> findAllPosts() {
        SqlSession sqlSession= MyBatisSqlSessionFactory.getSqlSession();
        PostDao projectDao=(PostDao)
                sqlSession.getMapper(PostDao.class);
        try {
            return projectDao.findAllPosts();
        }finally {
            sqlSession.close();
        }
    }

    public Post findPostById(Integer id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            PostDao projectDao =
                    sqlSession.getMapper(PostDao.class);
            return projectDao.findPostById(id);
        } finally {
            sqlSession.close();
        }
    }

    public Integer insertPost(Post post) {
        SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSession();
        int result=0;
        try {
            PostDao projectDao=
                    sqlSession.getMapper(PostDao.class);
            result=projectDao.insertPost(post);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public Integer updatePost(Post post) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        int result=0;
        try {
            PostDao projectDao =
                    sqlSession.getMapper(PostDao.class);
            result=projectDao.updatePost(post);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public Integer deletePost(Integer id) {
        SqlSession sqlSession =
                MyBatisSqlSessionFactory.getSqlSession();
        int result=0;
        try {
            PostDao projectDao =
                    sqlSession.getMapper(PostDao.class);
          result=  projectDao.deletePost(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return result;
    }
}
