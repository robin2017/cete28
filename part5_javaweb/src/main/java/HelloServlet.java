import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by robin on 2017/8/17.
 */
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter out= resp.getWriter();
        out.write("hello,servlet");

    }

    public HelloServlet(){
        System.out.println("-----constructor--");
    }

    @Override
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
        System.out.println("------init----");
        String name=config.getInitParameter("name");
        System.out.println(name);

    }
}

