/**
 * Created by robin on 2017/8/18.
 */
@javax.servlet.annotation.WebServlet(name = "RobinServlet", urlPatterns = "/RobinServlet")
public class RobinClassServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("utf-8");
    }
}

作者：小椰子表姐G
        链接：http://www.jianshu.com/p/6c8c9dd396c0
        來源：简书
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。