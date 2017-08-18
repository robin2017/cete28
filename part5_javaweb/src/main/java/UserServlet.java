import bean.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by robin on 2017/8/17.
 */
public class UserServlet extends HttpServlet {
    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context=this.getServletContext();
        context.setAttribute("name", "robin");

        String name = (String) context.getAttribute("name");



        String path=context.getInitParameter("contextConfigLocation");
        System.out.println(name);

        req.setCharacterEncoding("gbk");
        String username=req.getParameter("username");
        String userpass=req.getParameter("userpass");

        String action=req.getParameter("action");
         if("quit".equals(action)){
             exit();
         }
        boolean suc=false;

             suc=login(username,userpass);


        if(suc){
            //
            ArrayList<Product> list= null;

                list = getProduct();
            ArrayList res=new ArrayList();
            for(Product p:list){
                res.add(p.getName());
                res.add(p.getDes());
               // res.add(p.getCount());
            }

            for(Object str:res){
                System.out.println(str);
            }
            req.setAttribute("list", list);

            HttpSession session=req.getSession();
            session.setAttribute("user",username);



            req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);


//            resp.sendRedirect("list.jsp");

        }else{
            resp.sendRedirect("login.jsp");
        }

//        System.out.println("+++" + username);
//        resp.setContentType("text/html;charset=gbk");
//        PrintWriter out= resp.getWriter();
//        out.write("hello,servlet"+username);
//        if("robin".equals(username)){
//            //成功，要包装数据
////            resp.sendRedirect("login.jsp");
//            req.setAttribute("hh","dd");
//            req.getRequestDispatcher("success.jsp").forward(req,resp);
//        }


//        try {
//            System.out.println("++test+" + login("robin","123dd5"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

    private void exit() {

    }

    public ArrayList<Product> getProduct() {
        ArrayList<Product> list=new ArrayList<Product>();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try{
         connection=JDBCUtil.getConnection();
      statement=connection.prepareStatement("select * from product");

        resultSet=statement.executeQuery();
        while(resultSet.next()){
            Product product=new Product(resultSet.getString("proname"),resultSet.getString("prodes"),resultSet.getInt("procount"));
            list.add(product);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResut(resultSet);
            JDBCUtil.closeState(statement);
            JDBCUtil.closeCon(connection);

        }
        return list;
    }
    public boolean login(String name,String password) {
        Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        try {
            String passres = null;
            connection = JDBCUtil.getConnection();
              statement = connection.prepareStatement("select userpass from user where username=?");
            statement.setString(1, name);
             resultSet = statement.executeQuery();
            while (resultSet.next()) {
                passres = resultSet.getString("userpass");
            }
            if (passres == null)
                return false;
            if (passres.equals(password))
                return true;
            return false;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResut(resultSet);
            JDBCUtil.closeState(statement);
            JDBCUtil.closeCon(connection);
        }
        return false;

    }
    @Override
    public  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       doGet(req,resp);
    }

}

class GameJPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
