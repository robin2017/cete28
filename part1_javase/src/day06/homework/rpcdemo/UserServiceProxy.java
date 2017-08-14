package day06.homework.rpcdemo;

public class UserServiceProxy implements UserService {
	@Override
	public User logon(int id, String password) throws IdPassException {
		Request request = new Request("logon", new Class[] { int.class,
				String.class }, new Object[] { id, password });
		Response response = SocketUtil.remoteCall(request);
		if (!response.isSuccess())
			throw new RuntimeException(response.getException().getMessage());
		return (User) response.getObj();
	}
}
