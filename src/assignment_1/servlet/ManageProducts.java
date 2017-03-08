package assignment_1.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assignment_1.model.Products;
import assignment_1.model.ProductsInfo;
import assignment_1.model.Users;

/**
 * Servlet implementation class ManageProducts
 */
@WebServlet("/ManageProducts")
public class ManageProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Products aProduct = new Products();
		Users aUser = (Users)session.getAttribute("userBean");
		int id = aUser.getID();
		
	
		
		ArrayList<Products> searchResult = new ArrayList<Products>();
		searchResult = aProduct.returnProductsBySellerID(id);

	
		request.setAttribute("productResult", searchResult);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManageProducts.jsp");
		dispatcher.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
