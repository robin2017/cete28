package day06.homework.rpcdemo2;

public interface UserService {
	public User logon(int id, String password)
            throws IdPassException;
}
