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
* @version ：Mar 4, 2017 5:13:19 PM 
* 
*/
public class TransactionsDB {
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
	
	
	
	public boolean validateCreditCardDAO(String cardHolderName, String creditCardNumber, String cardType, String cVV){
		boolean cardExists = false;
		String SQL = "SELECT * from CreditCards";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(cardHolderName.equals( rs.getString(2) )&& creditCardNumber.equals(rs.getString(3))&& cVV.equals(rs.getString(7))) {
					cardExists = true;
				}    
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cardExists;
	}
	
	public int returnBalanceByCardNumberDAO(String aCardNumber) {
		String SQL = "SELECT * from CreditCards";
	    Statement stat;
	    int balance = 0;
	    Transactions aTransaction = new Transactions();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(aCardNumber.equals( rs.getString(3) )) {
					
					balance =  rs.getInt(4);
					
					
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}
	
	public void updateBalanceDAO(String aCardNumber, int cost)  {
		
		String SQL = "UPDATE CreditCards SET Balance = ? WHERE CreditCardNumber = ? ";
	    try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cost);
		    ps.setString(2, aCardNumber);
		    ps.executeUpdate();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
public ArrayList<Transactions>returnAllCreditCardDAO(){
		
		String SQL = "SELECT * from CreditCards";
	    Statement stat;
	    ArrayList<Transactions> transactionsList = new ArrayList<>();
		
	    try {
			stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()){
				Transactions aTransactions = new Transactions();//new a product object every iteration 
				aTransactions.setCardHolderName(rs.getString(2));
				aTransactions.setCreditCardNumber(rs.getString(3));
				aTransactions.setBalance(rs.getInt(4));
				aTransactions.setCardType(rs.getString(5));
				aTransactions.setcVV(rs.getString(7));
				
				
				transactionsList.add(aTransactions);
				
			}
//			for(Products a : productsList){
//				System.out.println(a.ID);
//			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
		
	    
	    return transactionsList;
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
