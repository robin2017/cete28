package robin.dao;

import robin.domain.Post;

import java.util.List;

/**
 * Created by robin on 2017/8/23.
 */
public interface PostDao {
    List<Post> findObjects();
    Post findObjectById(Integer id);
    Integer insertObject(Post project);
    Integer updateObject(Post project);
    Integer deleteObject(Integer id);
}

