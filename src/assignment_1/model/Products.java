package assignment_1.model;

import java.util.ArrayList;

public class Products {
	
	int ID;
	String productName;
	int productCategoryIndex;
	String productDescription;
	int price;
	int availableQuantity;
	int sellerId;
	String productThumbnail;
	
	String sellerName;
	String productCategory;
	String reviewDate;
	int rating;
	String review;
	String question;
	String answer;
	
	public Products(String productName, String category,int price, int quantity, int sellerID,String Description,String productimage) {
		super();
		this.productName = productName;
		this.price = price;
		this.availableQuantity = quantity;
		this.productDescription = Description;
		this.sellerId = sellerID;
		this.productCategory = category;
		this.productThumbnail = productimage;
	}
	
	
	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getProductCategoryIndex() {
		return productCategoryIndex;
	}


	public void setProductCategoryIndex(int productCategoryIndex) {
		this.productCategoryIndex = productCategoryIndex;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getAvailableQuantity() {
		return availableQuantity;
	}


	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public String getProductThumbnail() {
		return productThumbnail;
	}


	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}


	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Products> returnAllProducts(){
		ProductsDB DB =new ProductsDB();
		DB.connectMeIn();
		ArrayList<Products> allProducts = new ArrayList<Products>();
		allProducts = DB.returnAllProductsDB();
		DB.closeConnection();
		return allProducts;
		
	}

	

	public ArrayList<Products> returnProductsByKeyword(String Keyword){
		ProductsDB DB =new ProductsDB();
		DB.connectMeIn();
		ArrayList<Products> allProducts = new ArrayList<Products>();
		ArrayList<Products> selectedProducts = new ArrayList<Products>();
		allProducts = DB.returnAllProductsDB();
//		System.out.println(allProducts.size());
		for(Products aProduct : allProducts){
			
			//System.out.println(aProduct.ID+ ""+ aProduct.Price+ ""+aProduct.AvailableQuantity +""+aProduct.ProductCategoryIndex+ ""+aProduct.ProductDescription+""+aProduct.ProductName);
			if(aProduct.productName.toLowerCase().contains(Keyword.toLowerCase())){
				selectedProducts.add(aProduct);
//				System.out.println(aProduct.ProductName + "");
				
			}
		}
//		System.out.println(selectedProducts.size());
//		for(Products aFullProduct :selectedProducts){
//			ProductsInfo info = new ProductsInfo();
//			//System.out.println(aFullProduct.productName);
//			String category = info.returnCategoryByCategoryID(aFullProduct.productCategoryIndex);
//			String sellerName = info.returnSellerNameByUserID(aFullProduct.sellerId);
//			ProductsInfo reviewInfo = info.returnReviewBeanByProductID(aFullProduct.ID);
//			
//			aFullProduct.setProductCategory(category);
//			aFullProduct.setSellerName(sellerName);
//			aFullProduct.setRating(reviewInfo.rating);
//			aFullProduct.setReviewDate(reviewInfo.reviewDate);
//			aFullProduct.setReview(reviewInfo.review);
//		}
		
		DB.closeConnection();
		
//		for(Products a : selectedProducts){
//		System.out.println(a.productCategoryIndex);
//	}
		return selectedProducts;
		
	}
	public ArrayList<Products> returnProductsBySellerID(int sellerId){
		ProductsDB DB =new ProductsDB();
		DB.connectMeIn();
		ArrayList<Products> allProducts = new ArrayList<Products>();
		ArrayList<Products> selectedProducts = new ArrayList<Products>();
		allProducts = DB.returnAllProductsDB();
	//System.out.println(allProducts.size());
			for(Products aProduct : allProducts){
			if(aProduct.sellerId == sellerId){
					selectedProducts.add(aProduct);
				}
			}
	
		return selectedProducts;
		}
	
	public Products returnProductsByID(int id){
		ProductsDB DB =new ProductsDB();
		DB.connectMeIn();
		ArrayList<Products> allProducts = new ArrayList<Products>();
		//Products selectedProduct = new Products();
		allProducts = DB.returnAllProductsDB();

		for(Products aProduct : allProducts){
			

			if(aProduct.ID == id){
				DB.closeConnection();
				return aProduct;
				
			}
		}
		DB.closeConnection();
		return null;
	}
	
	public void editProducts(Products aProduct,String productName, int price, int quantity, String description){
		aProduct.setProductName(productName); 
		aProduct.setPrice(price); 
		aProduct.setProductDescription(description);
		aProduct.setAvailableQuantity(quantity);
		ProductsDB uDB = new ProductsDB();
		uDB.connectMeIn();
		uDB.editProductsDAO(aProduct);
		uDB.closeConnection();
	}
	public void addProducts(Products aProduct){
	
		ProductsDB uDB = new ProductsDB();
		uDB.connectMeIn();
		uDB.addProductsDAO(aProduct);
		uDB.closeConnection();
	}
	
}
