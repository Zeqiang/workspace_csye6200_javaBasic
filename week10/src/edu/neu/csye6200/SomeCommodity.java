package edu.neu.csye6200;

public class SomeCommodity {

	private String name;
	private int price;
	
	public SomeCommodity() {
		super();
	}

	public SomeCommodity(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
