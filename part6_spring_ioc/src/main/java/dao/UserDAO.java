package dao;

import beans.User;

/**
 * Created by robin on 2017/8/21.
 */
public interface UserDAO {
    void save(User u);
    void delete();
}