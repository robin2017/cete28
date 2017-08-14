package day03;

import day02.JDBCUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by robin on 2017/8/11.
 */
public class DaoSupport<T> implements Dao<T>{
    @Override
    public T findById(Serializable id, String sql,RowMapper rm) {  //这个是回调方法
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        T t=null;
        try {
            connection= JDBCUtil.getConnection();
            pstmt=connection.prepareStatement(sql);
            pstmt.setObject(1,id);
            rs=pstmt.executeQuery();
            if(rs.next()){
            //不同的表，包装方式不一样的，这个包装是变化的：只提炼一个标准接口，类似jdbc标准
            t= (T) rm.getRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            JDBCUtil.closeResut(rs);
//            JDBCUtil.closeCon(connection);
        }

        return t;
    }

    @Override
    public List<T> find(String sql, Object... obj) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<T>  list=null;


            connection= JDBCUtil.getConnection();
        try {
            pstmt=connection.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
       // pstmt.setObject(1);
        return null;
    }

    @Override
    public int saveOrUpOrDel(String sql, Object... obj) {
        return 0;
    }
}
