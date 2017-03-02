package assignment_1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductsInfoDB {
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
	
		
public ArrayList<ProductsInfo>returnAllProductCategoryDB(){
		
		String SQL = "SELECT * from ProductCategories";
	    Statement stat;
	    ArrayList<ProductsInfo> productsList = new ArrayList<>();
		
	    try {
			stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				ProductsInfo aProductInfo = new ProductsInfo();
				//new a product object every iteration !!!
				aProductInfo.setCategoryID(rs.getInt(1));
				aProductInfo.setProductCategory(rs.getString(2));
				productsList.add(aProductInfo);
				
			}
//			for(Products a : productsList){
//				System.out.println(a.productName);
//			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return productsList;
	}


public ArrayList<ProductsInfo>returnAllProductSellerDB(){
	
	String SQL = "SELECT * from Users";
    Statement stat;
    ArrayList<ProductsInfo> productsList = new ArrayList<>();
	
    try {
		stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery(SQL);
		while(rs.next()){
			ProductsInfo aProductInfo = new ProductsInfo();
			//new a product object every iteration !!!
			aProductInfo.setUserID(rs.getInt(1));
			aProductInfo.setSellerName(rs.getString(14));
			productsList.add(aProductInfo);
			
		}
//		for(Products a : productsList){
//			System.out.println(a.productName);
//		}
//		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return productsList;
}

public ArrayList<ProductsInfo>returnAllProductReviewDB(){
	
	String SQL = "SELECT * from CustomerReviews";
    Statement stat;
    ArrayList<ProductsInfo> productsList = new ArrayList<>();
	
    try {
		stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery(SQL);
		while(rs.next()){
			ProductsInfo aProductInfo = new ProductsInfo();
			//new a product object every iteration !!!
			aProductInfo.setProductID(rs.getInt(2));
			aProductInfo.setReviewDate(rs.getString(4));
			aProductInfo.setRating(rs.getInt(5));
			aProductInfo.setReview(rs.getString(6));
			
			productsList.add(aProductInfo);
			
		}
//		for(Products a : productsList){
//			System.out.println(a.productName);
//		}
//		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return productsList;
}

public ArrayList<ProductsInfo>returnAllProductQADB(){
	
	String SQL = "SELECT * from ProductQA";
    Statement stat;
    ArrayList<ProductsInfo> productsList = new ArrayList<>();
	
    try {
		stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery(SQL);
		while(rs.next()){
			ProductsInfo aProductInfo = new ProductsInfo();
			//new a product object every iteration !!!
			aProductInfo.setProductID(rs.getInt(2));
			aProductInfo.setQuestion(rs.getString(4));
			aProductInfo.setAnswer(rs.getString(5));
			
			productsList.add(aProductInfo);
			
		}
//		for(ProductsInfo a : productsList){
//			System.out.println(a.answer);
//		}
//		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return productsList;
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
