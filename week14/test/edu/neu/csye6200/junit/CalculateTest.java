package edu.neu.csye6200.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {
	
	Calculate calculation = new Calculate();
	
	int sum = calculation.add(3, 4);
	int testSum = 7;
	
	int diff = calculation.subtract(6, 2);
	int testDiff = 4;
	
	int product = calculation.mult(2, 3);
	int testProduct = 6;
	
	int result = calculation.divide(6, 2);
	int testResult = 3;
	
	@Test
	public void testAdd() {
//		fail("Not yet implemented");
		
		System.out.println("@Test sum(): " + sum + " = " + testSum);
		assertEquals(testSum, sum);
		
//		Thread t = new Thread(() -> {System.out.println("@Test sum(): " + sum + " = " + testSum);
//		assertEquals(testSum, sum);
//		});
//		t.start();
	}

	@Test
	public void testSubtract() {
//		fail("Not yet implemented");
		System.out.println("@Test diff(): " + diff + " = " + testDiff);
		assertEquals(testDiff, diff);
	}

	@Test
	public void testMult() {
//		fail("Not yet implemented");
		System.out.println("@Test product(): " + product + " = " + testProduct);
		assertEquals(testProduct, product);
	}

	@Test
	public void testDivide() {
//		fail("Not yet implemented");
		System.out.println("@Test result(): " + result + " = " + testResult);
		assertEquals(testResult, result);
	}

}
