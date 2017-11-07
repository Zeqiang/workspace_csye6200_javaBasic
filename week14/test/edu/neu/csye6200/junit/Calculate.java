package edu.neu.csye6200.junit;

public class Calculate {

	public int add(int a, int b) {
//		System.out.println("Adding values: ");
//		System.out.println(a + b);
		return a + b;
	}
	
	public int subtract(int a, int b) {
//		System.out.println("Subtracting values: ");
//		System.out.println(a - b);
		return a - b;
	}
	
	public int mult(int a, int b) {
//		System.out.println("Multiplying values: ");
//		System.out.println(a * b);
		return a * b;
	}
	
	public int divide(int a, int b) {
//		System.out.println("Dividing values: ");
//		System.out.println(a / b);
		return a / b;
	}
	
	public static void demo(){
		
		Thread t1 = new Thread(() -> {
			System.out.println("hahah");
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //wait for thread to complete before continuing
		
		Thread t = new Thread(() -> {
			Calculate ca = new Calculate();
			System.out.println(ca.add(1, 0));
			System.out.println(ca.subtract(3, 1));
			System.out.println(ca.mult(1, 3));
			System.out.println(ca.divide(8, 2));
		});
		t.start();
	}
}
