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
* @version ：Mar 5, 2017 6:28:11 PM 
* 
*/
public class OrderItemsDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	//static final String DB_URL = "jdbc:mysql://localhost/MVCApp"; 
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/yanx";
	
	

	//  Database credentials
	static final String USER = "yanx"; // Replace with your CSE_LOGIN
	static final String PASS = "1127";   // Replace with your CSE MySQL_PASSWORD
	
	public ArrayList<OrderItems>returnAllOrderItemsDAO(){
			
			String SQL = "SELECT * from OrderItems";
		    Statement stat;
		    ArrayList<OrderItems> orderItemsList = new ArrayList<>();
			
		    try {
				stat = conn.createStatement();
				
				ResultSet rs = stat.executeQuery(SQL);
				while(rs.next()){
					OrderItems anOrderItem = new OrderItems();//new a product object every iteration 
					anOrderItem.setId(rs.getInt(1));
					anOrderItem.setOrderId(rs.getInt(2));
					anOrderItem.setProductId(rs.getInt(4));
					anOrderItem.setRequestQuantity(rs.getInt(6));
					anOrderItem.setShippingStatus(rs.getInt(7));
					anOrderItem.setStatus(rs.getInt(9));
					
					//System.out.println(anOrderItem.getProductId());
					orderItemsList.add(anOrderItem);
					
				}
	//			for(Products a : productsList){
	//				System.out.println(a.ID);
	//			}
	//			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   
			
		    
		    return orderItemsList;
		}
	
	public void chanegItemStatusToCancelDAO(int itemsId)  {
		String SQL = "UPDATE OrderItems SET Status = 1 WHERE Id = ? ";
	    try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, itemsId);
		  
		    ps.executeUpdate();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void addOrderItemsDAO(OrderItems anOrderItems)  {
			
			try {
				  stmt = conn.createStatement();
				  String sql;
				  int orderId = anOrderItems.getOrderId();
				  int productId = anOrderItems.getProductId();
				  int quantity = anOrderItems.getRequestQuantity();
				  int shippingStatus = anOrderItems.getShippingStatus();
				  int shippingRefNo = anOrderItems.getShippingRefNo();
				  int status = anOrderItems.getStatus();
				  

				  sql = "INSERT INTO OrderItems (OrderId, ProductId, Quantity, ShippingStatus, ShippingRefNo, Status)" +
				          "VALUES ('" + orderId +
						  "', '" + productId + 
						  "', '" + quantity + 
						  "', '" + shippingStatus + 
						  "', '" + shippingRefNo + 
						  "', '" + status + "')";
				  
				  stmt.executeUpdate(sql);
				  
				  
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
