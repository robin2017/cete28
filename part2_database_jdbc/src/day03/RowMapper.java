package day03;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by robin on 2017/8/11.
 */
public interface RowMapper<T> {//一条记录包装成一个对象，这是一个标准接口
    public T getRow(ResultSet rs) throws SQLException;

}
