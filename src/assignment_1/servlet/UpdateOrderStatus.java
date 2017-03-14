package assignment_1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment_1.model.OrderItems;
import assignment_1.model.Products;
import assignment_1.model.ProductsInfo;

/**
 * Servlet implementation class UpdateOrderStatus
 */
@WebServlet("/UpdateOrderStatus")
public class UpdateOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String refer = request.getHeader("referer");
		if(refer.contains("ViewOrderDetail")) {
			int orderItemId = Integer.parseInt(request.getParameter("orderItemId"));
			OrderItems anOrderItem = new OrderItems();
			anOrderItem = anOrderItem.returnOrderItemsById(orderItemId);
			
			//System.out.println(anOrderItems.getRequestQuantity());
			
			Products aProducts = new Products();
			aProducts = aProducts.returnProductsByID(anOrderItem.getProductId());
			anOrderItem.setProducts(aProducts);
			
			//set subtatol

			int subTotal = anOrderItem.getRequestQuantity() * aProducts.getPrice(); 
			anOrderItem.setSubTotal(subTotal);
			request.setAttribute("anOrderItem", anOrderItem);
			
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateOrderStatus.jsp");
			dispatcher.forward(request, response);
		}
		else if(refer.contains("UpdateOrderStatus")){
	
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		String date = request.getParameter("date");
		
		int orderItemId = Integer.parseInt(request.getParameter("orderItemId"));
		int shippingStatus = Integer.parseInt(request.getParameter("shippingStatus"));
		OrderItems anOrderItem = new OrderItems();
		anOrderItem = anOrderItem.returnOrderItemsById(orderItemId);
		Products aProducts = new Products();
		aProducts = aProducts.returnProductsByID(anOrderItem.getProductId());
		anOrderItem.setProducts(aProducts);
		anOrderItem.setRequestQuantity(quantity);
		anOrderItem.setShippingStatus(shippingStatus);
		anOrderItem.setId(orderItemId);
		int subTotal = anOrderItem.getRequestQuantity() * aProducts.getPrice(); 
		anOrderItem.setSubTotal(subTotal);
		anOrderItem.updateOrderStatus(anOrderItem);
		
		request.setAttribute("anOrderItem", anOrderItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateOrderStatus.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
