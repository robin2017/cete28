import beanfactory.BeanFactory;
import beanfactory.IOCApplicationContext;
import beans.User;
import org.jdom.JDOMException;
import service.UserService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by robin on 2017/8/21.
 */
public class MainTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, JDOMException, IOException {



       BeanFactory factory = new IOCApplicationContext("beans.xml");
       // ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext();
        //通过工厂直接获取
        UserService userService = (UserService) factory.getBean("userService");
        //其实User也可以从工厂中获得
        User u=(User)factory.getBean("user");
        //User u = new User();
//        u.setUserName("yyb");
        u.setPassword("1234");
        userService.addUser(u);//打印结果yyb1234
    }
}
