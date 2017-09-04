package blog.dao;

import blog.domain.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by robin on 2017/8/23.
 */


public interface BlogDao {
    List<Blog> findObjects();
    Blog findObjectById(Integer id);
    Integer insertObject(Blog project);
    Integer updateObject(Blog project);
    Integer deleteObject(Integer id);
    List<Blog> findObjectsByName(@Param("title")String title);
}
