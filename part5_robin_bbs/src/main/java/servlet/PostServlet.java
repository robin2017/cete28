package servlet;

import entity.Post;
import service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by robin on 2017/8/18.
 */

public class PostServlet extends MethodDispatcherServlet {
    private PostServiceImpl service=new PostServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入postservlet类的doget方法");
        String method=req.getParameter("method");
        methodDispatcher(method,req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入postservlet类的list方法");
        List<Post> list=service.getAllPost();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/jsp/listPost.jsp").forward(req, resp);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id=req.getParameter("id");
        service.delPost(Integer.parseInt(id));
      //  list(req,resp);
        resp.sendRedirect("postServlet?method=list");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Post post=service.findPostById(Integer.parseInt(id));
        req.setAttribute("post", post);
        req.getRequestDispatcher("/WEB-INF/jsp/updatePost.jsp").forward(req, resp);
    }

    protected void updateConfire(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String keyword=req.getParameter("keyword");
        String content=req.getParameter("content");
        int i=service.updatePost(new Post(id,name,keyword,content));
        resp.sendRedirect("postServlet?method=list");
    }

}