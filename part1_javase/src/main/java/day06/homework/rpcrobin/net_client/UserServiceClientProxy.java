package day06.homework.rpcrobin.net_client;


import day06.homework.rpcrobin.net_common.*;

import java.util.List;


/**
 * Created by robin on 2017/8/9.
 */
public class UserServiceClientProxy implements UserService {
    @Override
    public User login(Integer id, String password) throws IdPassException {
        Request request=new Request("login",new Class[]{int.class,String.class},new Object[]{id,password});
        Response response=SocketUtil.remoteCall(request);
        if(response.isSuccess())
            return (User)response.getObj();
        throw new IdPassException(response.getException().getMessage());
    }

    @Override
    public List<User> getAllUsers() {
        Request request=new Request("getAllUsers",new Class[]{},new Object[]{});
        Response response=SocketUtil.remoteCall(request);
        if(response.isSuccess())
            return (List<User>)response.getObj();
        return null;
    }

    @Override
    public String getNameById(Integer id) {
        Request request=new Request("getNameById",new Class[]{int.class},new Object[]{id});
        Response response=SocketUtil.remoteCall(request);
        if(response.isSuccess())
            return (String)response.getObj();
        return null;
    }
}
