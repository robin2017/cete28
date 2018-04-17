package service;


import entity.Post;

import java.util.List;

/**�Ŀ��Ϣdao*/
public interface PostService {
	List<Post> findAllPosts();
	Post findPostById(Integer id);
	Integer insertPost(Post post);
	Integer updatePost(Post post);
	Integer deletePost(Integer id);
}
