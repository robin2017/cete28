package jdbc;

/**
 * Created by robin on 2017/8/18.
 */

import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static Properties prop = new Properties();
    private static ThreadLocal<Connection> tl =
            new ThreadLocal<Connection>();
    static {
        try {
            prop.load(JDBCUtil.class.getResourceAsStream("/database.properties"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static Connection getConn() {
        Connection con = tl.get();//�൱���ǰѵ�ǰ�߳���Ϊkeyȡvalue;
        if(con==null){
            try {
                Class.forName(prop.getProperty("driver"));
                con = DriverManager.getConnection(
                        prop.getProperty("url"), prop.getProperty("name"),
                        prop.getProperty("pass"));
                tl.set(con);//�൱�ڰѵ�ǰ�̶߳�����Ϊkey,con��Ϊvalue������Map�����С�
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;

    }
    public static void closeRs(ResultSet rs){
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    public static void closePt(PreparedStatement pstmt){
        if(pstmt!=null)
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    public static void closeConn(Connection con){
        if(con!=null)
            try {
                con.close();
                tl.remove();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    public static void closeConn(){
        Connection con = getConn();
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tl.remove();
    }
}

