package assignment_1.model;

public class ShoppingCartBean {

	Products aProduct;
	int requestQuantity;
	public ShoppingCartBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCartBean(Products aProduct, int requestQuantity) {
		super();
		this.aProduct = aProduct;
		this.requestQuantity = requestQuantity;
	}
	public Products getaProduct() {
		return aProduct;
	}
	public void setaProduct(Products aProduct) {
		this.aProduct = aProduct;
	}
	public int getRequestQuantity() {
		return requestQuantity;
	}
	public void setRequestQuantity(int requestQuantity) {
		this.requestQuantity = requestQuantity;
	}
	
	
}
