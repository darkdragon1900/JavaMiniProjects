package shop_management_system;

import java.util.Scanner;

public class Product {
	
	protected String productId;
	protected String productName;
	protected double price;
	protected int quantityAvailable;
	
	
	
	public Product(String productId, String productName, double price, int quantityAvailable) {
		
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantityAvailable=" + quantityAvailable + "]";
	}

	
	
	
	
	
	
	
	
	
}
