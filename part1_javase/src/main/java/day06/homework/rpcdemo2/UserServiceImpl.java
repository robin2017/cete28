package day06.homework.rpcdemo2;

public class UserServiceImpl implements UserService {
	private EntityContext entityContext;
	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}
	@Override
	public User logon(int id, String password) throws IdPassException {
		if(!entityContext.getUsers().containsKey(id))
			throw new IdPassException("id is not exists!");
		User user = entityContext.getUsers().get(id);
		if(!user.getPass().equals(password))
			throw new IdPassException("password is error!");
		return user;
		
	}

}
