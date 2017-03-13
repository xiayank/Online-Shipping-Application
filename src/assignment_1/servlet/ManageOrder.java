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
import assignment_1.model.Products;
import assignment_1.model.ProductsInfo;

/**
 * Servlet implementation class ManageOrder
 */
@WebServlet("/ManageOrder")
public class ManageOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));//correct
		int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
		
		OrderItems anOrderItems = new OrderItems();
		
		
		ArrayList<OrderItems> orderItemsList = anOrderItems.returnOrderItemsByOrderId(orderId);
		ArrayList<OrderItems>canceledItems = new ArrayList<>();
		
		
		for(OrderItems orderItems: orderItemsList){
			
			Products aProducts = new Products();
			aProducts = aProducts.returnProductsByID(orderItems.getProductId());
			ProductsInfo info = new ProductsInfo();
			String sellerName = info.returnSellerNameByUserID(orderItems.getSellerId());
			
			aProducts.setSellerName(sellerName);

			
			//set product into item
			orderItems.setProducts(aProducts);
			/*
			//set subtatol into item
			int subTotal = orderItems.getRequestQuantity() * aProducts.getPrice(); 
			orderItems.setSubTotal(subTotal);
			
			*/
			
			//check the cancel status
			// true -> canceled -> not show 
			
			if(orderItems.returnItemsCancelStatusById(orderItems.getId())){
				
				canceledItems.add(orderItems);
				
			}
			
			
			
		}
		
		for(OrderItems aCanceledItems: canceledItems){
			orderItemsList.remove(aCanceledItems);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("orderItemsList", orderItemsList);
		request.setAttribute("orderNumber", orderNumber);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManageOrders.jsp");
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
