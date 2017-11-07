package edu.neu.csye6200;

import edu.neu.csye6200.api.AbstractPerson;

public class Person extends AbstractPerson {

	static private final long serialVersionID = 86769678L;
	static private int personCount = 0;
	
	public Person() {
		super();
	}

	public Person(int age,String fname , String lname ) {
		super();
		this.setAge(age);
		this.setFname(fname);
		this.setLname(lname);
	}
	
	@Override
	public String toString() {
		return this.getFname();
	}

	@Override
	public void show() {
		System.out.println(this.toString());
	}

}
