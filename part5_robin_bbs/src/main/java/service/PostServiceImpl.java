package service;


import entity.Post;
import jdbc.DaoSupport;
import jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by robin on 2017/8/18.
 */

public class PostServiceImpl {
    public static void main(String[] args) {
        PostServiceImpl service=new PostServiceImpl();
        List<Post> list=service.getAllPost();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    private DaoSupport<Post> ds = new DaoSupport<Post>();

    public List<Post> getAllPost() {
        return ds.find("select * from post", new PostRowMapper());
    }

    public Post findPostById(int id) {
        return ds.findById(id, "select * from post where id= ?", new PostRowMapper());

    }

    public int updatePost(Post product) {
        return ds.saveOrUpOrDel(
                "update post set name=?,keyword=?,content=? where id=?",
                product.getName(), product.getKeyword(),
                product.getContent(), product.getId());

    }
    public int delPost(int id){
        return ds.saveOrUpOrDel("delete from post where id = ?",id);
    }
    public int addPost(Post post){
        return ds.saveOrUpOrDel("insert into post(id,name,keyword,content) values (?,?,?,?)",
                post.getId(),
                post.getName(),
                post.getKeyword(),
                post.getContent());
    }
}

class PostRowMapper implements RowMapper<Post> {

    //@Override
    public Post getRow(ResultSet rs) throws SQLException {
        Post p = new Post(rs.getInt("id"), rs.getString("name"),
                rs.getString("keyword"), rs.getString("content"));
        return p;
    }

}
