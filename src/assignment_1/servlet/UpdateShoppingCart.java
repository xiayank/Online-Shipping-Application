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
import assignment_1.model.ShoppingCartBean;

/**
 * Servlet implementation class UpdateShoppingCart
 */
@WebServlet("/UpdateShoppingCart")
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Products aProduct = new Products();
		ArrayList<ShoppingCartBean> shoppingCartList = null;
		if(session.getAttribute("shoppingCartList") == null){
			shoppingCartList = new ArrayList<ShoppingCartBean>();
			//session.setAttribute("shoppingCartList", shoppingCartList);
			System.out.println("session null");
		}else{
			System.out.println("session exits");
			shoppingCartList = (ArrayList<ShoppingCartBean>) session.getAttribute("shoppingCartList");
		}
		//get ID of the product which has been click to add to cart
		int id = Integer.parseInt(request.getParameter("ID"));
		//get the product by ID
		aProduct =aProduct.returnProductsByID(id);
		
		//get request quantity
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		ShoppingCartBean aShoppingCart = new ShoppingCartBean(aProduct, quantity);
		shoppingCartList.add(aShoppingCart);
		
		session.setAttribute("shoppingCartList", shoppingCartList);
		//System.out.println(quantity);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShoppingCart.jsp");
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
