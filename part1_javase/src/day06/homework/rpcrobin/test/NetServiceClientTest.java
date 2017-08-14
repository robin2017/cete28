package day06.homework.rpcrobin.test;


import day06.homework.rpcrobin.net_client.UserServiceClientProxy;
import day06.homework.rpcrobin.net_common.IdPassException;
import day06.homework.rpcrobin.net_common.User;

import java.util.List;


/**
 * Created by robin on 2017/8/9.
 */
public class NetServiceClientTest {
    public static void main(String[] args){
        UserServiceClientProxy clientProxy=new UserServiceClientProxy();
        try {
           System.out.println(clientProxy.logon(1,"123456"));
            System.out.println("--------------------");

            List<User> list=clientProxy.getAllUsers();
            for(User user:list)
                System.out.println(user);

            System.out.println("--------------------");

            System.out.println(clientProxy.getNameById(1));
        } catch (IdPassException e) {
           System.out.println(e.getMessage());
        }
    }
}
