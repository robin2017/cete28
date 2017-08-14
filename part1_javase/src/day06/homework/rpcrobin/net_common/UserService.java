package day06.homework.rpcrobin.net_common;


import java.util.List;

public interface UserService {
	public User logon(int id, String password)
            throws IdPassException;
    public List<User> getAllUsers();
    public String getNameById(int id);
}
