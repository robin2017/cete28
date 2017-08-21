package service;


import entity.Post;
import org.robin.jdbc.DaoSupport;
import org.robin.jdbc.RowMapper;
import org.robin.jdbc.sql.BeanSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by robin on 2017/8/18.
 */

public class PostServiceImpl {
    private Post post = new Post();
    private DaoSupport<Post> ds = new DaoSupport<Post>();

    public List<Post> getAllPost() {
        return ds.find(BeanSQL.getBeanByConditionSQL(post), new PostRowMapper());
    }

    public Post findPostById(int id) {
        return ds.findById(id, BeanSQL.getBeanByConditionSQL(post, "id"), new PostRowMapper());
    }

    public int updatePost(Post product) {
        return ds.saveOrUpOrDel(BeanSQL.updateBeanByConditionSQL(post, "id"),
                product.getId(),
                product.getName(), product.getKeyword(),
                product.getContent(), product.getId());
    }

    public int delPost(int id) {
        return ds.saveOrUpOrDel(BeanSQL.deleteBeanByConditionSQL(post, "id"), id);
    }

    public int addPost(Post post) {
        return ds.saveOrUpOrDel(BeanSQL.insertBeanSQL(post),
                post.getId(),
                post.getName(),
                post.getKeyword(),
                post.getContent());
    }
}

class PostRowMapper implements RowMapper<Post> {
    public Post getRow(ResultSet rs) throws SQLException {
        Post p = new Post(rs.getInt("id"), rs.getString("name"),
                rs.getString("keyword"), rs.getString("content"));
        return p;
    }
}
