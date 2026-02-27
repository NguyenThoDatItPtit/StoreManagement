package model;

public class Product {

	private int id;
	private String name;
	private double price;
	private double installment;
	private int quantity;
	private int category;
	private String description;

	public Product() {
	}

	// ADD PRODUCT
	public Product(String name, double price, double installment, int quantity, int category, String description) {

		this.name = name;
		this.price = price;
		this.installment = installment;
		this.quantity = quantity;
		this.category = category;
		this.description = description;
	}

	// ✅ FIX ERROR CONSTRUCTOR
	public Product(int id, String name, double price, int quantity) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// ===== Getter Setter =====
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getInstallment() {
		return installment;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}
}