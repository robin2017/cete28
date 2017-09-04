package robin.service;

import robin.domain.Post;

import java.util.List;

public interface PostService {
	List<Post> findObjects();
	Post findObjectById(Integer id);
	void saveObject(Post entity);
	void updateObject(Post entity);
	void deleteObject(Integer id);
}
