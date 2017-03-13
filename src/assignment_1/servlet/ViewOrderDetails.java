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

/**
 * Servlet implementation class ViewOrderDetails
 */
@WebServlet("/ViewOrderDetails")
public class ViewOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("orderId"));
		int ordernumber = Integer.parseInt(request.getParameter("orderNumber"));
		ArrayList<OrderItems> anOrder = new ArrayList<OrderItems>();
		OrderItems anOrder2 = new OrderItems();
		anOrder = anOrder2.returnOrderItemsByOrderId(id);
		ArrayList<OrderItems> anOrdercancelled = new ArrayList<OrderItems>();
		for (OrderItems anOrder3 : anOrder){
			Products aProduct = new Products();
			int productid = anOrder3.getProductId();
			
		anOrder3.setProducts(aProduct.returnProductsByID(productid));
			if(anOrder3.returnItemsCancelStatusById(anOrder3.getId())){
			
			anOrdercancelled.add(anOrder3);
			
		}
		}
		
		for(OrderItems aCanceledItems: anOrdercancelled){
			anOrder.remove(aCanceledItems);
		}
		
		//System.out.println("orderid" + anOrder.size());
		HttpSession session = request.getSession();
		request.setAttribute("orderdetail", anOrder);
	//	request.setAttribute("Product",aProductList);
		session.setAttribute("ordernumber",ordernumber);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewOrderDetail.jsp");
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
