package day02;

import day01.homework.JDBCDemo;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by robin on 2017/8/10.
 */
public class JDBCUtil {
    private static Properties prop=new Properties();
    private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
    static{
        try {
            prop.load(JDBCDemo.class.getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con=tl.get();
        if(con==null) {
            try {
                Class.forName(prop.getProperty("driver"));
                Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
                tl.set(connection);
                return connection;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void closeCon(Connection connnection){
        try {
            connnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeState(PreparedStatement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResut(ResultSet resultSet){
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
