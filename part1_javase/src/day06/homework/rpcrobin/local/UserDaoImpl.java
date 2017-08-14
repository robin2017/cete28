package day06.homework.rpcrobin.local;


import day06.homework.rpcrobin.net_common.IdPassException;
import day06.homework.rpcrobin.net_common.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 2017/8/9.
 */
public class UserDaoImpl implements UserDao {

    private UserDaoImpl(){}
    private static UserDaoImpl instance=null;
    public static UserDaoImpl getInstance(){
        if(instance!=null){}
        else{
            synchronized (UserDaoImpl.class){
                if(instance==null)
                    instance=new UserDaoImpl();
            }
        }
        return instance;
    }

    @Override
    //这个方法调用自己的，懒得调用底层了
    public User logon(int id, String password) throws IdPassException {
        List<User> list=getAllUsers();
        for(User user:list){
            if(id==user.getUid())
                if(password.equals(user.getPass()))
                    return user;
                else
                    throw new IdPassException("error password");

        }
        throw new IdPassException("no id");
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list=new ArrayList<User>();
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtil.getConnection();
            pstmt=connection.prepareStatement("select * from user");
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
             //   System.out.println(rs.getInt("uid")+","+rs.getString("name")+","+rs.getString("pass")+","+rs.getString("email"));
                User user=new User(resultSet.getInt("uid"),
                        resultSet.getString("name"),
                        resultSet.getString("pass"),
                        resultSet.getString("email"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResut(resultSet);
            JDBCUtil.closeState(pstmt);
            JDBCUtil.closeCon(connection);
        }
        return null;
    }

    @Override
    public String getNameById(int id) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtil.getConnection();
            pstmt=connection.prepareStatement("select name from user where uid=?");
            pstmt.setInt(1,id);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                //System.out.println(rs.getString("name"));
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResut(resultSet);
            JDBCUtil.closeState(pstmt);
            JDBCUtil.closeCon(connection);
        }
        return null;
    }
}
