package dao;

import beans.User;

/**
 * Created by robin on 2017/8/21.
 */
public class UserDAOImpl implements UserDAO {
    //@Override
    public void save(User u) {
        System.out.println("User:" + u.toString());
    }
   // @Override
    public void delete() {
        System.out.println("delete User");

    }
}
