package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by robin on 2017/8/18.
 */

public class MethodDispatcherServlet extends HttpServlet {
    public void methodDispatcher(String methodName,HttpServletRequest req, HttpServletResponse resp)  {
        try {
            System.out.println("--methodDispatcher---class---:"+this.getClass().getSimpleName());
            System.out.println("--methodDispatcher---method--:"+methodName);
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,(HttpServletRequest)req, (HttpServletResponse)resp);

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}