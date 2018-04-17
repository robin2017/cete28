package service;

import java.util.List;

/**
 * Created by robin on 2017/8/22.
 */
public interface BeanService<BeanType> {
    //增删改查操作
    Integer insertObject(BeanType t);
    Integer deleteObject(Integer id);
    Integer updateObject(BeanType t);
    List<BeanType> findAllObjects();
    BeanType findObjectById(Integer id);
}
