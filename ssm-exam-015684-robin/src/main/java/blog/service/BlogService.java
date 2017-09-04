package blog.service;

import blog.domain.Blog;

import java.util.List;

/**
 * Created by robin on 2017/8/23.
 */
public interface BlogService {

    List<Blog> findObjects();
    Blog findObjectById(Integer id);
    Integer insertObject(Blog project);
    Integer updateObject(Blog project);
    Integer deleteObject(Integer id);

    List<Blog> findObjectsByName(String name);
}
