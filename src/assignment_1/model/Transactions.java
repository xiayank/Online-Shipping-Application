package assignment_1.model;

import java.sql.SQLException;
import java.util.ArrayList;

/** 
* @function TODO 
* @author 
* @version ：Mar 4, 2017 3:50:54 PM 
* 
*/
public class Transactions {
	//credit card info
	String cardHolderName;
	String creditCardNumber;
	int balance;
	String cardType;
	String cVV;
	int userId;
	String expirationDate;
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getcVV() {
		return cVV;
	}
	public void setcVV(String cVV) {
		this.cVV = cVV;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public boolean validateCreditCard(String cardHolderName, String creditCardNumber, String cardType, String cVV){
		boolean cardExists = false;
		TransactionsDB db = new TransactionsDB();
		db.connectMeIn();
		cardExists = db.validateCreditCardDAO( cardHolderName, creditCardNumber, cardType, cVV);
		db.closeConnection();
		
		return cardExists;
	}
	
	public int returnBalanceByCardNumber(String aCardNumber) {
		TransactionsDB db = new TransactionsDB();
		db.connectMeIn();
		int balance = db.returnBalanceByCardNumberDAO(aCardNumber);
		db.closeConnection();
		return balance;
		
	}
	public void updateBalance(String aCardNumber, int cost)  {
		TransactionsDB db = new TransactionsDB();
		db.connectMeIn();
		db.updateBalanceDAO(aCardNumber, cost);
		db.closeConnection();
		
	}
	
	
	
	public ArrayList<Transactions>returnAllCreditCard(){
		TransactionsDB db = new TransactionsDB();
		db.connectMeIn();
		ArrayList<Transactions> cardList = new ArrayList<Transactions>();
		cardList = db.returnAllCreditCardDAO();
		db.closeConnection();
		return cardList;
		
	}
	
	
	
}
