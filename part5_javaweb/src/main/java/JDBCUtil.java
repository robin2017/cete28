import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static Properties prop=new Properties();
    private static ThreadLocal<Connection>
            tl=new ThreadLocal<Connection>();
    static{
        try {
            //放在resource文件夹下面
            prop.load(JDBCUtil.class.getResourceAsStream("/database.properties"));
        } catch (IOException e) {
            System.out.println("加载失败---");
            e.printStackTrace();
        }catch(Throwable t){
            System.out.println("加载失败-+++--");
            t.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con=tl.get();
        if(con==null) {
            try {
                Class.forName(prop.getProperty("driver"));
                con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
                tl.set(con);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    public static void closeCon(Connection con){
        if(con!=null)
            try {
                con.close();
                tl.remove();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    public static void closeCon(){
        Connection con = getConnection();
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tl.remove();
    }
    public static void closeState(PreparedStatement pstmt){
        if(pstmt!=null)
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    public static void closeResut(ResultSet rs){
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }


}

