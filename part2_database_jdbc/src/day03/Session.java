package day03;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by robin on 2017/8/11.
 */
public class Session {

    public int save(Object object){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        int n=0;
        return n;
    }
    private PreparedStatement getstatement(Connection connection,Object object)
            throws SQLException {
        PreparedStatement pstmt=connection.prepareStatement(getSql(object));
        Class c=object.getClass();
        Field[] fs=c.getDeclaredFields();
      //  for(int i=0;
        return null;
    }
    private String getSql(Object object){
        StringBuffer s=new StringBuffer();
        s.append("insert into ");
        Class c=object.getClass();
        String tableName=c.getSimpleName();
        s.append(tableName).append("(");
        Field[]  dd;
        //不写了
        return null;
    }
}
