package edu.neu.csye6200;

public class Student extends Person{
	
	private double gpa;

	public Student() {
		super();
	}

	public Student(double gpa) {
		super();
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
