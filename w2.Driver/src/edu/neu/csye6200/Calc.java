package edu.neu.csye6200;

public class Calc {

	private int result = 0; // store calculated result

	// default constructor
	public Calc() {
		super();
	}

	// overload constructor
	public Calc(int result) {
		super();
		this.result = result;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public void add(int a, int b) {
		this.result = a + b;
	}
	
	public void subtract(int a, int b) {
		this.result = a - b;
	}
	
	public void mult(int a, int b) {
		this.result = a * b;
	}
	
	public void divide(int a, int b) {
		this.result = a / b;
	}

	public static void demo() {
		
		Calc objectCalc; // declare variable that can hold a Calc object
		objectCalc = new Calc(); // instantiate object from class Calc

		// object.result = 7;
		objectCalc.setResult(7);
		objectCalc.mult(2, 3);
		System.out.println(objectCalc.getResult());

		Calc objectCalc2 = new Calc(8);
		objectCalc2.add(2, 3);
		System.out.println(objectCalc2.getResult());
		
		Calc objectCalc3 = new Calc();
		objectCalc3.subtract(3, 2);
		System.out.println(objectCalc3.getResult());
		
		Calc objectCalc4 = new Calc();
		objectCalc4.divide(3, 2);
		System.out.println(objectCalc4.getResult());
	}

}
