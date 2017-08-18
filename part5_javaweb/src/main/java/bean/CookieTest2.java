package bean;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by robin on 2017/8/18.
 */
public class CookieTest2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       Cookie[] cookies=req.getCookies();
        for(Cookie cookie:cookies){
            System.out.println("cookie:"+cookie.getName()+cookie.getValue());
        }
        System.out.println("cookietest2");
    }
}
