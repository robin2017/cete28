package day06.homework.rpcrobin.local;


import day06.homework.rpcrobin.net_common.IdPassException;
import day06.homework.rpcrobin.net_common.User;
import day06.homework.rpcrobin.net_common.UserService;

import java.util.List;

/**
 * Created by robin on 2017/8/9.
 */
public class UserServiceImpl implements UserService {
    public static void main(String[] args){
        try {
            System.out.println(new UserServiceImpl().logon(1,"123456"));
        } catch (IdPassException e) {
            System.out.println(e.getMessage());
        }
    }
    private UserDao userDao;
    public UserServiceImpl(){
        userDao=UserDaoImpl.getInstance();
    }
    @Override
    public User logon(int id, String password) throws IdPassException {
     return userDao.logon(id,password);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public String getNameById(int id)
    {
        return userDao.getNameById(id);
    }
}
