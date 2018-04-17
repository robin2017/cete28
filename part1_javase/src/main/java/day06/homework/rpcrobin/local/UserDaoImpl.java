package day06.homework.rpcrobin.local;


import day06.homework.rpcrobin.net_common.IdPassException;
import day06.homework.rpcrobin.net_common.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 2017/8/9.
 */
public class UserDaoImpl implements UserDao {

    private static List<User> list = new ArrayList<User>();

    static {
        list.add(new User(111, "robin", "123456", "robin.seu@foxmail.com"));
        list.add(new User(222, "peter", "234567", "peter.seu@foxmail.com"));

    }

    private UserDaoImpl() {
    }

    private static UserDaoImpl instance = null;

    public static UserDaoImpl getInstance() {
        if (instance != null) {
        } else {
            synchronized (UserDaoImpl.class) {
                if (instance == null)
                    instance = new UserDaoImpl();
            }
        }
        return instance;
    }

    @Override
    //这个方法调用自己的，懒得调用底层了
    public User login(Integer id, String password) throws IdPassException {
        List<User> list = getAllUsers();
        for (User user : list) {
            if (id == user.getUid())
                if (password.equals(user.getPass()))
                    return user;
                else
                    throw new IdPassException("error password");

        }
        throw new IdPassException("no id");
    }

    @Override
    public List<User> getAllUsers() {
        return list;
    }

    @Override
    public String getNameById(Integer id) {

        for (User user : list) {
            if (id == user.getUid()) {
                return user.getName();
            }
        }
        return null;
    }
}
