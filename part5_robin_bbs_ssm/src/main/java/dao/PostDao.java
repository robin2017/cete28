package dao;


import entity.Post;

import java.util.List;

/**�Ŀ��Ϣdao*/
public interface PostDao {
	List<Post> findObjects();
	Post findObjectById(Integer id);
	Integer insertObject(Post project);
	Integer updateObject(Post project);
	Integer deleteObject(Integer id);
}
