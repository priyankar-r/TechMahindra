package week2task;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private String productID;
	private String name;
	private int quantity;
	private Location location;

	public Product(String productID, String name, int quantity, Location location) {
		this.productID = productID;
		this.name = name;
		this.quantity = quantity;
		this.location = location;
	}

	public String getProductID() {
		return productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Location getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}
}
