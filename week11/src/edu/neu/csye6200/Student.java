package edu.neu.csye6200;

public class Student {
	
	private String fname;
	private String lname;
	private int age;
	private double gpa;
	private String parentFname;
	private String parentLname;
	
	public Student() {
		super();
	}

	public Student(String fname, String lname, int age, double gpa, String parentFname, String parentLname) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gpa = gpa;
		this.parentFname = parentFname;
		this.parentLname = parentLname;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getParentFname() {
		return parentFname;
	}

	public void setParentFname(String parentFname) {
		this.parentFname = parentFname;
	}

	public String getParentLname() {
		return parentLname;
	}

	public void setParentLname(String parentLname) {
		this.parentLname = parentLname;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.fname + this.lname;
	}
}
