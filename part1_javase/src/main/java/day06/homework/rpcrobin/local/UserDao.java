package day06.homework.rpcrobin.local;


import day06.homework.rpcrobin.net_common.IdPassException;
import day06.homework.rpcrobin.net_common.User;

import java.util.List;

/**
 * Created by robin on 2017/8/9.
 */
public interface UserDao {
    public User login(Integer id, String password) throws IdPassException;
    public List<User> getAllUsers();
    public String getNameById(Integer id);
}
