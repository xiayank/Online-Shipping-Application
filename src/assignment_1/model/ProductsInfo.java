package assignment_1.model;

import java.util.ArrayList;

public class ProductsInfo {
	int categoryID; //CategoryID
	int productID;//ProductID
	int userID;//UserID
	String productCategory;
	String sellerName;
	public String getSellerName() {
		return sellerName;
	}

//test
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}




	String reviewDate;
	int rating;
	String review;
	String question;
	String answer;
	public ProductsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}


	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}




	public String returnCategoryByCategoryID(int id){
		
		ProductsInfoDB DB = new ProductsInfoDB();
		DB.connectMeIn();
		ArrayList<ProductsInfo> allInfo = new ArrayList<>();
		allInfo = DB.returnAllProductCategoryDB();
		for(ProductsInfo aInfo : allInfo){
			if(aInfo.categoryID == id){
				DB.closeConnection();
				//System.out.println(id);
				return aInfo.productCategory;
				
			}
		}
		DB.closeConnection();
		return null;
		
	}
	
	public String returnSellerNameByUserID(int id){
		
		ProductsInfoDB DB = new ProductsInfoDB();
		DB.connectMeIn();
		ArrayList<ProductsInfo> allInfo = new ArrayList<>();
		allInfo = DB.returnAllProductSellerDB();
		for(ProductsInfo aInfo : allInfo){
			if(aInfo.userID == id){
				DB.closeConnection();
				//System.out.println(id);
				return aInfo.sellerName;
				
			}
		}
		DB.closeConnection();
		return null;
		
	}	
	
	public ProductsInfo returnReviewBeanByProductID(int id){
		
		ProductsInfoDB DB = new ProductsInfoDB();
		DB.connectMeIn();
		ArrayList<ProductsInfo> allInfo = new ArrayList<>();
		
		allInfo = DB.returnAllProductReviewDB();
		
		for(ProductsInfo aInfo : allInfo){
			if(aInfo.productID == id){
				DB.closeConnection();
				//System.out.println(id);
				return aInfo;
				
			}
		}
		DB.closeConnection();
		return null;
		
	}

	public ProductsInfo returnQABeanByProductID(int id){
		
		ProductsInfoDB DB = new ProductsInfoDB();
		DB.connectMeIn();
		ArrayList<ProductsInfo> allInfo = new ArrayList<>();
		
		allInfo = DB.returnAllProductQADB();
		
		for(ProductsInfo aInfo : allInfo){
			if(aInfo.productID == id){
				DB.closeConnection();
				//System.out.println(id);
				return aInfo;
				
			}
		}
		DB.closeConnection();
		return null;
		
	}
	public void editQA(ProductsInfo aInfo,String question, String answer){
		aInfo.setQuestion(question);
		aInfo.setAnswer(answer);
		ProductsInfoDB uDB = new ProductsInfoDB();
		uDB.editProductsInfoDAO(aInfo);
		
		uDB.closeConnection();
	}
}
