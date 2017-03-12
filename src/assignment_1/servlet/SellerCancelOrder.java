package assignment_1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assignment_1.model.OrderItems;
import assignment_1.model.Products;

/**
 * Servlet implementation class SellerCancelOrder
 */
@WebServlet("/SellerCancelOrder")
public class SellerCancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerCancelOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderItemId = Integer.parseInt(request.getParameter("orderItemId"));
		OrderItems anOrderItem = new OrderItems();
		anOrderItem = anOrderItem.returnOrderItemsById(orderItemId);
		
		//System.out.println(anOrderItems.getRequestQuantity());
		
		Products aProducts = new Products();
		aProducts = aProducts.returnProductsByID(anOrderItem.getProductId());
		anOrderItem.setProducts(aProducts);
		
		//set subtatol
		HttpSession session = request.getSession();
		int subTotal = anOrderItem.getRequestQuantity() * aProducts.getPrice(); 
		anOrderItem.setSubTotal(subTotal);
		session.setAttribute("anOrderItem", anOrderItem);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SellerCancelOrder.jsp");
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
