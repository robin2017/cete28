package day06.homework.rpcdemo;

public class UserServiceTest {
	public static void main(String[] args) {
		EntityContext entityContext = new EntityContext();
		UserServiceImpl us = new UserServiceImpl();
		us.setEntityContext(entityContext);
		
		try {
			User user = us.logon(1001, "123");
			System.out.println(user);
		} catch (IdPassException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
