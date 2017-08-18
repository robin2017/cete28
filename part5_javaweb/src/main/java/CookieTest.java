import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by robin on 2017/8/18.
 */
public class CookieTest extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cookie cookie=new Cookie("name","zhangshan");
        cookie.setMaxAge(10000);
        resp.addCookie(cookie);
        System.out.println("cookietest");
    }
}
