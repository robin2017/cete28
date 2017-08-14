package day06.homework.rpcdemo;

public interface UserService {
	public User logon(int id, String password)
            throws IdPassException;
}
