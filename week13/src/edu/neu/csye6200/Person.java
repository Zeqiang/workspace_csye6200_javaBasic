package edu.neu.csye6200;

public class Person {
	
	private int id;
	private String name;
	private int numbers;
	
	public Person() {
		super();
	}

	public Person(int id, String name, int numbers) {
		super();
		this.id = id;
		this.name = name;
		this.numbers = numbers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public String toString() {
		return this.getId() + "-" + this.getName() + "-" + this.getNumbers();
	}
}
