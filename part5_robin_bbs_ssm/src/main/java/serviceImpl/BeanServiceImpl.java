package serviceImpl;

import dao.BeanDao;
import entity.Post;
import org.apache.ibatis.session.SqlSession;
import service.BeanService;
import utils.MyBatisSqlSessionFactory;

import java.util.List;

/**
 * Created by robin on 2017/8/22.
 */
public class BeanServiceImpl<BeanType> implements BeanService<BeanType> {

    public static void main(String[] args) {
        List<Post> list=new BeanServiceImpl<Post>().findAllObjects();
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public Integer insertObject(BeanType t) {
        return null;
    }

    public Integer deleteObject(Integer id) {
        return null;
    }

    public Integer updateObject(BeanType t) {
        return null;
    }

    public List<BeanType> findAllObjects() {
        SqlSession sqlSession= MyBatisSqlSessionFactory.getSqlSession();
        BeanDao<BeanType> projectDao=(BeanDao<BeanType>)
                sqlSession.getMapper(BeanDao.class);
        try {
            return projectDao.findAllObjects();
        }finally {
            sqlSession.close();
        }
    }

    public BeanType findObjectById(Integer id) {
        return null;
    }
}
