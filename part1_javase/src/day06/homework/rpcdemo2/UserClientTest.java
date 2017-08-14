package day06.homework.rpcdemo2;

public class UserClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserServiceProxy us = new UserServiceProxy();
		try {
			User user = us.logon(100001, "123");
			User user2 = us.logon(1001, "123");

		   System.out.println(user);
		} catch (IdPassException e) {
			System.out.println(e.getMessage());
		}

	}

}
