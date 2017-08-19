package service;

import entity.User;
import org.robin.jdbc.DaoSupport;
import org.robin.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by robin on 2017/8/18.
 */
public class UserServiceImpl {
    private DaoSupport<User> dao = new DaoSupport<User>();
    public User login(String name,String password){
        List<User> users = dao.find("select * from user where name=? and password=?", new UserRowMapper(), name,password);
        if(users.size()>0)
            return users.get(0);
        return null;
    }
    public int insertUser(User user){
       return dao.saveOrUpOrDel("insert into user(id,name,password,phone,email) values (?,?,?,?,?)",
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getPhone(),
                user.getEmail());

    }
}
class UserRowMapper implements RowMapper<User> {

   // @Override
    public User getRow(ResultSet rs) throws SQLException {
        User user = new User(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("phone"),
                rs.getString("email"));
        return user;
    }

}