package day03;

import java.io.Serializable;
import java.util.List;

/**
 * Created by robin on 2017/8/11.
 */

public interface Dao<T> {
    //列出通用方法，比如主键查询
    T findById(Serializable id,String sql,RowMapper<T> rm);
    // 如有条件查询
    List<T> find(String sql,Object...obj);
    //增删改
    int saveOrUpOrDel(String sql,Object...obj);
}
