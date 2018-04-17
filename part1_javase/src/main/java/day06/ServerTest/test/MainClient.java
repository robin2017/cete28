package day06.ServerTest.test;

/**
 * Created by robin on 2017/8/8.
 */
public class MainClient
{
    public static void main(String[] args) throws IdPassException {
        UserServiceProxy userServiceProxy=new UserServiceProxy();
        System.out.println(userServiceProxy.login(123,"22"));
    }
}
