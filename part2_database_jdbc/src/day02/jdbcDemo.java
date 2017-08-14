package day02;

import java.sql.Connection;

/**
 * Created by robin on 2017/8/10.
 */
public class jdbcDemo {



    public static void main(String[] args){
        Connection connection=JDBCUtil.getConnection();
        System.out.println(connection);
        String sql="select * from ";

        String name1="'zhangshan'";
        String name2="'zhangshan' or 1=1";

    }
}
