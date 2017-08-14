package day01.homework;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo {

    private static Properties p=new Properties();
    static{
        try {
            p.load(JDBCDemo.class.getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            Class.forName(String.valueOf(p.get("driver")));
            Connection connection= DriverManager.getConnection(String.valueOf(p.get("url")), String.valueOf(p.get("user")), String.valueOf(p.get("password")));
            PreparedStatement pstmt=
                    connection.prepareStatement("insert into student(stuNo,stuName,stuAge)values(?,?,?)");
            pstmt.setInt(1, 12345);
            pstmt.setString(2, "abc");
            pstmt.setInt(3,1);
            int n=pstmt.executeUpdate();


            PreparedStatement pstmt1 =
                    connection.prepareStatement("select * from student");
            ResultSet rs = pstmt1.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("stuNo")+","+rs.getString("stuName")+","+rs.getInt("stuAge"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}