package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by robin on 2017/8/18.
 */
public class MySessionListener implements HttpSessionListener{
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("创建session");
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("销毁session");
    }
}
