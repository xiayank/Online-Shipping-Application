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
import assignment_1.model.ShoppingCartBean;
import assignment_1.model.Transactions;
import assignment_1.model.Users;

/**
 * Servlet implementation class TransactionConfirmation
 */
@WebServlet("/TransactionConfirmation")
public class TransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardHolderName = request.getParameter("first_name") + " " + request.getParameter("last_name");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String  zipCode = request.getParameter("zip_code");
		
		String fullAddress = request.getParameter("address") + "," + request.getParameter("city") + "," +request.getParameter("state") + "," + request.getParameter("zip_code");
		String phoneNumber = request.getParameter("phone_number");
		String creditCardNumber = request.getParameter("car_number");
		String cardType = request.getParameter("cardType");
		String cVV = request.getParameter("cVV");
		
		HttpSession session = request.getSession();
		
		ArrayList<ShoppingCartBean> shoppingCartList = (ArrayList<ShoppingCartBean>) session.getAttribute("shoppingCartList");
		int totalCost = (int) session.getAttribute("totalCost");
		
		int validCard = 0; 
		Transactions aTransaction = new Transactions();
		boolean exsitCard =  aTransaction.validateCreditCard(cardHolderName, creditCardNumber, cardType, cVV);
		
		if(exsitCard){
			//charge card balance
			validCard = 0;// successfully charged
			int nowBalance = aTransaction.returnBalanceByCardNumber(creditCardNumber);
			int remainedBalance = nowBalance - totalCost;
			
			
			if(remainedBalance >= 0){
				aTransaction.updateBalance(creditCardNumber, remainedBalance);
				//System.out.println(remainedBalance);
				int orderNumber = 1000000 + (int)(Math.random() * 1111111);
				Orders anOrder = new Orders();
				Users activeUser = (Users) session.getAttribute("userBean");
				
				anOrder.setCustomerId(activeUser.getID());
				anOrder.setCreditCardNumber(creditCardNumber);
				anOrder.setOrderNumber(orderNumber);
				anOrder.setShippingAddress(fullAddress);
				anOrder.setTotalCost(totalCost);
				
				//add current order into database
				anOrder.addOrder(anOrder);

				//System.out.println(activeUser.getID());

				//System.out.println(activeUser.getUserId());

				//after add into database, then get the primary key Id from database
				Orders currentOrder = new Orders();
				currentOrder = currentOrder.returnOrderByOrderNumber(anOrder.getOrderNumber());
				
				ArrayList<OrderItems> itemsOfAnOrder = new ArrayList<>();
				
				for(ShoppingCartBean aShoppingCartBean: shoppingCartList){
					OrderItems anOrderItems = new OrderItems();
					
					anOrderItems.setOrderId(currentOrder.getId()); // the FOREIGN KEY of OrderItems is OrderId
					anOrderItems.setProductId(aShoppingCartBean.getaProduct().getID());
					anOrderItems.setRequestQuantity(aShoppingCartBean.getRequestQuantity());
//					anOrderItems.setShippingRefNo(1);
//					anOrderItems.setShippingStatus(1);
//					anOrderItems.setStatus(1);
					
					itemsOfAnOrder.add(anOrderItems);
				//	System.out.println(aShoppingCartBean.getaProduct().getID()+" " + currentOrder.getId() + " "+aShoppingCartBean.getRequestQuantity());
				}
				
				anOrder.setItemsOfAnOrder(itemsOfAnOrder);
				
				//add all Order Items of current order into database
				for(OrderItems anOrderItem: itemsOfAnOrder){
					anOrderItem.addOrderItems(anOrderItem);
				}
				
				
			}else{
				
				validCard = 1; //no sufficient fund, show error!
			}
			
			
		}else{
			
			validCard = 2; //invalid card, show error !
		}
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("city", city);
		session.setAttribute("state", state);
		session.setAttribute("zipCode", zipCode);
		session.setAttribute("phoneNumber", phoneNumber);
		session.setAttribute("fullAddress", fullAddress);
		session.setAttribute("validCard", validCard);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionConfirmation.jsp");
		//System.out.println(aProduct.getProductDescription());
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
