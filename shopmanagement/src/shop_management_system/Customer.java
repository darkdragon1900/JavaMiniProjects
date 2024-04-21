package shop_management_system;

import java.util.ArrayList;


	public class Customer {
	    
	    private ArrayList<Product> purchasedProducts;
	    private String customerId;
	    private String customerName;
	    private String contactNumber;
	    
	   
	    public Customer(String customerId, String customerName, String contactNumber) {
	        this.customerId = customerId;
	        this.customerName = customerName;
	        this.contactNumber = contactNumber;
	        this.purchasedProducts = new ArrayList<>();
	    }

	  
	    public String getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(String customerId) {
	        this.customerId = customerId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getContactNumber() {
	        return contactNumber;
	    }

	    public void setContactNumber(String contactNumber) {
	        this.contactNumber = contactNumber;
	    }
	    
	   
	    public void addProduct(Product product) {
	        if (product != null) {
	            purchasedProducts.add(product);
	        } else {
	            System.out.println("Cannot add null product.");
	        }
	    }
	    
	  
	    public void removeProduct(Product product) {
	        purchasedProducts.remove(product);
	    }
	    
	  
	    public ArrayList<Product> getPurchasedProducts() {
	        return purchasedProducts;
	    }
}


	
	

