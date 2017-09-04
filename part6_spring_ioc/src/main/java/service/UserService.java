package service;

import beans.User;
import dao.UserDAO;

/**
 * Created by robin on 2017/8/21.
 */
public class UserService {

    private UserDAO userDAO;

    public void addUser(User u)
    {
        this.userDAO.save(u);
    }
    /**
     * @return the userDAO
     */
    public UserDAO getUserDAO()
    {
        return userDAO;
    }
    /**
     * @param userDAO
     *            the userDAO to set
     */
    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }
}