package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Thing implements Comparable<Thing>, Runnable {
	
	private int number;

	public Thing() {	// default constuctor
		super();
		this.number = 0;
	}

	public Thing(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void task() {
		System.out.println(Thing.class.getSimpleName() + ".task()...");
		List<Thing> l = new ArrayList<>();	// instantiate Collection (container) object
		l.add(new Thing(3));  // add a Thing object to container
		l.add(new Thing(1));  // add a Thing object to container		
		l.add(new Thing(2));  // add a Thing object to container

		System.out.println("Sorting Things out...");

		Collections.sort(l);  // sort our list of Things
		System.out.println(l.size() + " Things in list.");
		// print all objects in ocntainer l
		for (Thing e : l) {
			System.out.println(e);
		}
		
//		l.forEach(System.out::println);	// use to print all objects in container l
		
//		l.stream().sorted().forEach(System.out::println);	// sort container and print each using Stream API
	}

	@Override
	public String toString() {
		int number = this.getNumber();	// assign Thing's n to numnber
		Integer integerObj = new Integer(number);	// wrap number int in class Integer
		
		return integerObj.toString();
	}
	
	@Override
	public int compareTo(Thing obj) {
		return Integer.compare(this.getNumber(), obj.getNumber());
	}

	@Override
	public void run() {
		System.out.println("Running1...");
		this.task();
	}

	public static void demo() {
		Thing obj = new Thing(); // instantiate Thing class using default constructor
		System.out.println(obj.getNumber());	// use instantiated object
		System.out.println(obj.toString());		// output toString to console
//		obj.task();			// execute task() method in original main() thread

		
		{
			Thread t = new Thread(new Thing());		// instantiate Thread object with Thing runnable object
			t.start();    	// begin execution of task() in a new thread
		}
		
		{
			Runnable lam = () -> {System.out.println("runnable2");};
			Thread t = new Thread(lam);
			t.start();
		}
		{
			Thread t = new Thread(() -> {System.out.println("runnable3");});
			t.start();
		}
	}
}
