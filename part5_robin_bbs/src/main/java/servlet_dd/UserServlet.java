package servlet_dd;

/**
 * Created by robin on 2017/8/18.
 */


        import entity.User;
        import service.UserServiceImpl;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;

/**
 * Created by robin on 2017/8/18.
 */

public class UserServlet extends HttpServlet {
    private UserServiceImpl userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String method=req.getParameter("method");
        if("login".equals(method)){
            login(req,resp);
        }else if("register".equals(method)){
            register(req,resp);
        }else if ("exit".equals(method)){
            exit(req, resp);
        }else if ("registerConfire".equals(method)){
            registerConfire(req, resp);
        }else{
            System.out.println("error");
        }
    }

    private void registerConfire(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int res=0;
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        res = userService.insertUser(new User(id,name,password,phone,email));
        if(res==1){
            //注册成功,进入登陆
            System.out.println("注册成功");
            resp.sendRedirect("userServlet?method=login");
        }else{
            //注册失败，继续界面
            System.out.println("注册失败");
            resp.sendRedirect("userServlet?method=register");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        User user=userService.login(name,password);
        if(user==null){
            //登陆失败，重定向（不需要保存信息）
            System.out.println("用户--->"+name+":登陆失败");
            resp.sendRedirect("login.jsp");
        }else{
            //登陆成功，跳转(需要保存信息)
            System.out.println("用户--->"+name+":登陆成功");
            //session是tomcat启动是就创建了
            HttpSession session=req.getSession();
            //同一个用户同一个session，可以在跳转界面得到同一个session，所以也可以用重定向
            //user是一个java对象，可以在jstl中获取一个java对象
            session.setAttribute("user",user);
            resp.sendRedirect("postServlet?method=list");

        }

    }
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req,resp);
    }
    private void exit(HttpServletRequest req, HttpServletResponse resp){

    }
}
