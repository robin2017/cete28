package service;

import entity.User;
import org.robin.jdbc.DaoSupport;
import org.robin.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl {
	private DaoSupport<User> dao = new DaoSupport<User>();
    public User login(String username,String userpass){
    	List<User> users = dao.find("select * from user where username=? and userpass=?", new UserRowMapper(), username,userpass);
    	if(users.size()>0)
    		return users.get(0);
    	return null;
    }
}
class UserRowMapper implements RowMapper<User>{

	@Override
	public User getRow(ResultSet rs) throws SQLException {
		User user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("userpass"));
		return user;
	}
	
}