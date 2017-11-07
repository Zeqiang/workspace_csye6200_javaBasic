package edu.neu.csye6200;

import edu.neu.csye6200.api.AbstractPerson;

public class Person extends AbstractPerson {

	@Override
	public String toString() {
		return this.getFname();
	}
	
	@Override
	public void show() {
		System.out.println(this.toString());
	}

}
