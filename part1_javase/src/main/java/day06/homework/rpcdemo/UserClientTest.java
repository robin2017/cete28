package day06.homework.rpcdemo;

public class UserClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserServiceProxy us = new UserServiceProxy();
		try {
			User user = us.logon(10001, "12345");
		   System.out.println(user);
		} catch (IdPassException e) {
			System.out.println(e.getMessage());
		}

	}

}
