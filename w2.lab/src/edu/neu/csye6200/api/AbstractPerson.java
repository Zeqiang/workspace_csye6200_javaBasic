package edu.neu.csye6200.api;

public abstract class AbstractPerson {

	private int age;
	private String fname;
	private String lname;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	abstract public void show();	//abstract methods
}
