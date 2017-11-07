package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Thing implements Comparable<Thing>, Runnable{

	private int number;

	public Thing() {
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
	
	public void task(){
		System.out.println(Thing.class.getSimpleName() + " task()...");
		
		List<Thing> l = new ArrayList<>();
		
		l.add(new Thing(3));
		l.add(new Thing(1));
		l.add(new Thing(2));
		
		System.out.println("sorting...");		
//		Collections.sort(l);
		
		System.out.println(l.size() + " " +"Things in the List");
		
//		for(Thing e : l){
//			System.out.println(e);
//		}
		
		l.stream().sorted().forEach(System.out :: println);
//		l.forEach(System.out :: println);
	}
	
	@Override
	public int compareTo(Thing obj) {
		return Integer.compare(this.getNumber(), obj.getNumber());
	}
	
	@Override
	public void run() {
		System.out.println("Running ...");
		this.task();
	}
	
	@Override
	public String toString(){
		int number = this.getNumber();
		Integer intN = new Integer(number);
		return intN.toString();
	}
	
	public static void demo(){
		
		Thing obj = new Thing();
		
		System.out.println(obj.getNumber());
		System.out.println(obj.toString());
		
//		obj.task();
		
		Thread t = new Thread(new Thing());
		t.start();
	}

}
