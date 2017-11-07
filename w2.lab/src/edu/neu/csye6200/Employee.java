package edu.neu.csye6200;

public class Employee extends Person {

	private int employeeId;

	public Employee() {
		super();
	}

	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
