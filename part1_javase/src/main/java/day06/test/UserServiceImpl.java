package day06.test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by robin on 2017/8/8.
 */
public class UserServiceImpl implements UserService {
    private EntityContext entityContext;
    public void setEntityContext(EntityContext entityContext){
        this.entityContext=entityContext;
    }
    public static void main(String[] args) throws IOException {
        EntityContext entityContext=new EntityContext();
        UserServiceImpl userService=new UserServiceImpl();
        userService.setEntityContext(entityContext);
        try {
            userService.login(10012,"123");
        } catch (IdPassException e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public User login(int id, String password) throws IdPassException {
        HashMap<Integer, User> hashMap = null;
        try {
            hashMap = entityContext.getUsers("user.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        User user = hashMap.get(id);


            if (user == null)
                throw new IdPassException("no id");
            if (!password.equals(user.getPassword()))
                throw new IdPassException("error ");
            return user;



    }
}
