package day06.ServerTest.test;

import java.io.IOException;

/**
 * Created by robin on 2017/8/8.
 */


public class UserServiceProxy implements UserService{
    @Override
    public User login(int id, String password) throws IdPassException {

        Request request=new Request();
        request.setMethodName("login");
        request.setParamTypes(new Class[]{Integer.class, String.class});
        request.setObjs(new Object[]{id, password});
        try {
            Response response=SocketUtil.remoteCall(request);
            if(!response.isSuccess()) {
                System.out.println(response.getException().getMessage());
                return null;
            }
            User user=(User)response.getObj();
            return user;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
