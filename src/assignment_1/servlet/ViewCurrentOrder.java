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

import assignment_1.model.OrderItems;
import assignment_1.model.Orders;
import assignment_1.model.Products;
import assignment_1.model.Users;

/**
 * Servlet implementation class ViewCurrentOrder
 */
@WebServlet("/ViewCurrentOrder")
public class ViewCurrentOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCurrentOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users aUser = (Users) session.getAttribute("userBean");
		int userId = aUser.getID();
		ArrayList<OrderItems> anOrderItem = new ArrayList<OrderItems>();
		OrderItems anOrderItem2 = new OrderItems();
		anOrderItem = anOrderItem2.returnOrderItemsBySellerId(userId);
		//System.out.println("Orderlistbysellerid: " + anOrderItem);
		Orders anOrder = new Orders();
		ArrayList<Orders> anOrderList = new ArrayList<Orders>();
		for (OrderItems anOrderItem3: anOrderItem){
			int orderId = anOrderItem3.getOrderId();
		//	System.out.println("Orderid: " + orderId);
			anOrder = anOrder.returnOrderByOrderId(orderId);	
			anOrderList.add(anOrder);
		}
		//System.out.println("Orderlist: " + anOrderList);
		request.setAttribute("currentOrdersOfSeller", anOrderList);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCurrentOrders.jsp");
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
