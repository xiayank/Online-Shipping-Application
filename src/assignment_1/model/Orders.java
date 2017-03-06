package assignment_1.model;

import java.util.ArrayList;

/** 
* @function TODO
* @author 
* @version ：Mar 5, 2017 6:17:14 PM 
* 
*/
public class Orders {
	int id;
	int customerId;
	int totalCost;
	String orderDate;
	String shippingAddress;
	String creditCardNumber;
	int orderNumber;
	ArrayList<OrderItems> itemsOfAnOrder;
	
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public ArrayList<OrderItems> getItemsOfAnOrder() {
		return itemsOfAnOrder;
	}

	public void setItemsOfAnOrder(ArrayList<OrderItems> itemsOfAnOrder) {
		this.itemsOfAnOrder = itemsOfAnOrder;
	}

	public ArrayList<OrderItems> returnItemsByOrderId(int anOrderId){
		//OrdersDB db = new OrdersDB();
		OrderItems orderItems = new OrderItems();
		ArrayList<OrderItems> allOrderItems = orderItems.returnAllOrderItems();
		ArrayList<OrderItems> itemsOfAnOrder = new ArrayList<>();
		for(OrderItems anOrderItem :  allOrderItems){
			if(anOrderItem.orderId == anOrderId){
				itemsOfAnOrder.add(anOrderItem);
			}
		}
		//db.closeConnection();
		return itemsOfAnOrder;
	}
	
	public ArrayList<Orders>returnAllOrder(){
		OrdersDB db = new OrdersDB();
		db.connectMeIn();
		ArrayList<Orders> allOrders = new ArrayList<Orders>();
		allOrders = db.returnAllOrdersDAO();
		db.closeConnection();
		return allOrders;
		
	}
	
	public void addOrder(Orders anOrder)  {
		OrdersDB db = new OrdersDB();
		db.connectMeIn();
		db.addOrderDAO(anOrder);
		db.closeConnection();
		
	}
	
	public Orders returnOrderByOrderNumber(int OrderNumber){
		OrdersDB DB =new OrdersDB();
		DB.connectMeIn();
		ArrayList<Orders> allOrders = new ArrayList<Orders>();
		//Products selectedProduct = new Products();
		allOrders = DB.returnAllOrdersDAO();

		for(Orders anOrder : allOrders){
			

			if(anOrder.orderNumber == OrderNumber){
				DB.closeConnection();
				return anOrder;
				
			}
		}
		DB.closeConnection();
		return null;
	}
	
	
	
}
