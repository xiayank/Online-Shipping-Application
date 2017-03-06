package assignment_1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** 
* @function TODO
* @author 
* @version ：Mar 5, 2017 6:28:25 PM 
* 
*/
public class OrdersDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	//static final String DB_URL = "jdbc:mysql://localhost/MVCApp"; 
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/yanx";
	
	

	//  Database credentials
	static final String USER = "yanx"; // Replace with your CSE_LOGIN
	static final String PASS = "1127";   // Replace with your CSE MySQL_PASSWORD\
	
	
	
	public ArrayList<Orders>returnAllOrdersDAO(){
		String SQL = "SELECT * from Orders";
	    Statement stat;
	    ArrayList<Orders> orderList = new ArrayList<>();
		
	    try {
			stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				Orders anOrders = new Orders();//new a product object every iteration 
				anOrders.setId(rs.getInt(1));
				anOrders.setCustomerId(rs.getInt(2));
				anOrders.setTotalCost(rs.getInt(3));
				anOrders.setShippingAddress(rs.getString(5));
				anOrders.setCreditCardNumber(rs.getString(7));
				anOrders.setOrderNumber(rs.getInt(8));
				
				
				orderList.add(anOrders);
				
			}
//			for(Products a : productsList){
//				System.out.println(a.ID);
//			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return orderList;
	}
	
	public void addOrderDAO(Orders anOrder)  {
		
		try {
			  stmt = conn.createStatement();
			  String sql;
			  int customerId = anOrder.getCustomerId();
			  int totalCost = anOrder.getTotalCost();
			  String shippingAddress = anOrder.getShippingAddress();
			  String creditCardNumber = anOrder.getCreditCardNumber();
			  int orderNumber = anOrder.getOrderNumber();
			  
			  
			 
			  

			  sql = "INSERT INTO Orders (CustomerId, TotalCost, ShippingAddress, CreditCardNumber, OrderNumber)" +
			          "VALUES ('" + customerId +
					  "', '" + totalCost + 
					  "', '" + shippingAddress + 
					  "', '" + creditCardNumber + 
					  "', '" + orderNumber + "')";
			  
			  stmt.executeUpdate(sql);
			  
			  
			  //add Order Items in order to database 
//			  ArrayList<OrderItems> itemsOfAnOrder = anOrder.getItemsOfAnOrder();
//			  
//			  for(OrderItems anOrderItems :itemsOfAnOrder){
//				  anOrderItems.addOrderItems(anOrderItems);
//			  }
			  
			  
			  
			  } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
	
	}
	
	
	
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
