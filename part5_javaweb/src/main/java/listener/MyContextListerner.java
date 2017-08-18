package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by robin on 2017/8/18.
 */
public class MyContextListerner implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("创建context监听器");
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("销毁context监听器");
    }
}
