package servlet;

import entity.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService ps = new ProductService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("list".equals(action)){
			list(request, response);
		}
		if("updateUI".equals(action)){
			updateUI(request, response);
		}
		if("update".equals(action))
			update(request, response);
		if("del".equals(action))
			del(request,response);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ps.delProd(id);
		response.sendRedirect("ProductServlet?action=list");
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = ps.getAll();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/WEB-INF/product/list.jsp").forward(request, response);
		
	}
	private void updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id  = Integer.parseInt(request.getParameter("id"));
		Product product = ps.findById(id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/WEB-INF/product/updateUI.jsp").forward(request, response);
		
	}
     private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String proname = request.getParameter("proname");
		String prodes = request.getParameter("prodes");
		int procount =Integer.parseInt(request.getParameter("procount"));
		Product product = new Product(id, proname, prodes, procount);
		ps.update(product);
		response.sendRedirect("ProductServlet?action=list");
		
		
	}

}
