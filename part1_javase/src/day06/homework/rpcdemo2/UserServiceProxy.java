package day06.homework.rpcdemo2;

public class UserServiceProxy implements UserService {
	private String sessionId;
	@Override
	public User logon(int id, String password) throws IdPassException {



		Request request = new Request("logon", new Class[] { int.class,
				String.class }, new Object[] { id, password });
		if (sessionId!=null);
		{
			//System.out.println();
			request.setSessionId(sessionId);
		}
		Response response = SocketUtil.remoteCall(request);

		if (!response.isSuccess())
			throw new RuntimeException(response.getException().getMessage());
		//此时登陆成功
		sessionId=response.getSessionId();

		return (User) response.getObj();
	}
}
