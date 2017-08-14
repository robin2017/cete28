package day06.test;

/**
 * Created by robin on 2017/8/8.
 */
public interface UserService {
    public User login(int id,String password) throws IdPassException;
}
