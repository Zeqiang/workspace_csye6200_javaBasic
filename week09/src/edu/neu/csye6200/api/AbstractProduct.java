package edu.neu.csye6200.api;

public abstract class AbstractProduct {
	
	public int id;
	public String name;
	public int stock;
	
	public AbstractProduct(int id, String name, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
	}
}
