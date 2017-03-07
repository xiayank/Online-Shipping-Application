package assignment_1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductsDB {
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
	
	public ArrayList<Products>returnAllProductsDB(){
		
		String SQL = "SELECT * from Products";
	    Statement stat;
	    ArrayList<Products> productsList = new ArrayList<>();
		
	    try {
			stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				Products aProduct = new Products();//new a product object every iteration 
				aProduct.setID(rs.getInt(1));
				aProduct.setProductName(rs.getString(2));
				aProduct.setProductCategoryIndex(rs.getInt(3));
				aProduct.setProductDescription(rs.getString(4));
				aProduct.setPrice(rs.getInt(5));
				aProduct.setAvailableQuantity(rs.getInt(6));
				aProduct.setSellerId(rs.getInt(8));
				aProduct.setProductThumbnail(rs.getString(11));
				
				productsList.add(aProduct);
				
			}
//			for(Products a : productsList){
//				System.out.println(a.ID);
//			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //Add more info from other tables using foreign key
		for(Products aFullProduct :productsList){
			ProductsInfo info = new ProductsInfo();
			//System.out.println(aFullProduct.productName);
			String category = info.returnCategoryByCategoryID(aFullProduct.productCategoryIndex);
			String sellerName = info.returnSellerNameByUserID(aFullProduct.sellerId);
			ProductsInfo reviewInfo = info.returnReviewBeanByProductID(aFullProduct.ID);
			ProductsInfo QAInfo = info.returnQABeanByProductID(aFullProduct.ID);
			
			//set category
			aFullProduct.setProductCategory(category);
			//set sellerName
			aFullProduct.setSellerName(sellerName);
			//set review
			aFullProduct.setRating(reviewInfo.rating);
			aFullProduct.setReviewDate(reviewInfo.reviewDate);
			aFullProduct.setReview(reviewInfo.review);
			//set QA
			aFullProduct.setQuestion(QAInfo.question);
			aFullProduct.setAnswer(QAInfo.answer);
			
		}
	    
	    return productsList;
	}
	
	public void updateAvailableQuantityDAO(int productId, int newQuantity)  {
			
			String SQL = "UPDATE Products SET AvailableQuantity = ? WHERE Id = ? ";
		    try {
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, newQuantity);
			    ps.setInt(2, productId);
			    ps.executeUpdate();
			    
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
