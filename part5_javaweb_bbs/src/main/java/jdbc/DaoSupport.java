package jdbc;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoSupport<T> implements Dao<T>{

	@Override
	public T findById(Serializable id, String sql,RowMapper<T> rm) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T t = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setObject(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				//把这条记录包装成一个对象
				//不同的表包装方式是不一样的，对于写通用操作来说这个包装应该是变化的
				t = rm.getRow(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//
		}
		return t;
	}

	@Override
	public List<T> find(String sql, RowMapper<T> rm,Object... obj) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> lists = new ArrayList<T>();
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement(sql);
			for(int i = 0; i < obj.length;i++){
				pstmt.setObject(i+1, obj[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				T t = rm.getRow(rs);
				lists.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public int saveOrUpOrDel(String sql, Object... obj) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement(sql);
			for(int i = 0; i < obj.length;i++){
				pstmt.setObject(i+1, obj[i]);
			}
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

}
