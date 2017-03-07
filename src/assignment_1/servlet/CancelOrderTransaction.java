package assignment_1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment_1.model.OrderItems;
import assignment_1.model.Orders;
import assignment_1.model.Transactions;

/**
 * Servlet implementation class CancelOrderTransaction
 */
@WebServlet("/CancelOrderTransaction")
public class CancelOrderTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cancelOrderItemId = Integer.parseInt(request.getParameter("orderItemId"));
		OrderItems anOrderItems = new OrderItems();
		//1.set item status to canceled = 1 
		anOrderItems = anOrderItems.returnOrderItemsById(cancelOrderItemId);
		anOrderItems.chanegItemStatus(cancelOrderItemId);
		
		//2.put refund
		Orders anOrders = new Orders();
		anOrders = anOrders.returnOrderByOrderId(anOrderItems.getOrderId());
		int refund =  anOrderItems.getSubTotal();
		String refundCardNumber = anOrders.getCreditCardNumber();
		Transactions anTransactions = new Transactions(); 
		int balance = anTransactions.returnBalanceByCardNumber(refundCardNumber);
		int newBalance = refund + balance;
		anTransactions.updateBalance(refundCardNumber, newBalance);
		
		//3.put back available quantity
		int refundQuantity = anOrderItems.getRequestQuantity();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
