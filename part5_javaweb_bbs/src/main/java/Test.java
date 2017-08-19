import java.sql.Connection;

import org.robin.jdbc.JdbcUtil;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = JdbcUtil.getConn();
		System.out.println(con);
	}

}
