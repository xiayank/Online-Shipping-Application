package assignment_1.model;

import java.util.ArrayList;

/** 
* @function TODO
* @author 
* @version ：Mar 5, 2017 6:16:56 PM 
* 
*/
public class OrderItems {
	int id;
	int orderId;
	int productId;
	int requestQuantity;
	int shippingStatus;
	int shippingRefNo;
	int status;
	int subTotal;
	Products products;
	
	
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getRequestQuantity() {
		return requestQuantity;
	}
	public void setRequestQuantity(int requestQuantity) {
		this.requestQuantity = requestQuantity;
	}
	public int getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(int shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public int getShippingRefNo() {
		return shippingRefNo;
	}
	public void setShippingRefNo(int shippingRefNo) {
		this.shippingRefNo = shippingRefNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public ArrayList<OrderItems>returnAllOrderItems(){
		OrderItemsDB db = new OrderItemsDB();
		db.connectMeIn();
		ArrayList<OrderItems> allOrderItems = new ArrayList<OrderItems>();
		allOrderItems = db.returnAllOrderItemsDAO();
		db.closeConnection();
		return allOrderItems;
		
	}
	
	public void addOrderItems(OrderItems anOrderItems)  {
		OrderItemsDB db = new OrderItemsDB();
		db.connectMeIn();
		db.addOrderItemsDAO(anOrderItems);
		db.closeConnection();
	}
	
	public OrderItems returnOrderItemsById(int id){
		OrderItemsDB db = new OrderItemsDB();
		db.connectMeIn();
		ArrayList<OrderItems> allOrderItems = new ArrayList<OrderItems>();
		
		allOrderItems = db.returnAllOrderItemsDAO();
		for(OrderItems anOrderItems:allOrderItems){
			if(anOrderItems.id == id){
				db.closeConnection();
				return anOrderItems;
				
			}
		}
		
		
		db.closeConnection();
		return null;
		
	}
	
	public ArrayList<OrderItems>returnOrderItemsByOrderId(int orderId){
		OrderItemsDB db = new OrderItemsDB();
		db.connectMeIn();
		ArrayList<OrderItems> allOrderItems = new ArrayList<OrderItems>();
		ArrayList<OrderItems> currentOrderItems = new ArrayList<OrderItems>();
		allOrderItems = db.returnAllOrderItemsDAO();
		for(OrderItems anOrderItems:allOrderItems){
			if(anOrderItems.orderId == orderId){
				currentOrderItems.add(anOrderItems);
				
				
			}
		}
		
		
		db.closeConnection();
		return currentOrderItems;
		
	}
}
