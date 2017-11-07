package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Thing{

	private int number;
	private String name;

	public Thing() {
		super();
		this.number = 0;
	}

	public Thing(int number) {
		super();
		this.number = number;
	}

	public Thing(String name) {
		super();
		this.name = name;
	}

	public Thing(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void demo(){
		System.out.println(Thing.class.getSimpleName() + " Demo()...");
		
		List<Thing> lis = new ArrayList<>();
		
		lis.add(new Thing(3, "c"));
		lis.add(new Thing(1, "a"));
		lis.add(new Thing(2, "b"));
		
		System.out.println("sorting...");	
		
		// 1
//		Collections.sort(lis);
		
		// 2
		Collections.sort(lis, new Comparator<Thing>() {
			public int compare(Thing t1, Thing t2) {
				return Integer.compare(t1.getNumber(), t2.getNumber());
			}
		});
		
		// 3
		Collections.sort(lis, new Comparator<Thing>() {
			public int compare(Thing t1, Thing t2) {
				return t1.getName().compareTo(t2.getName());
			}
		});
		
		// 4
		lis.sort(Comparator.comparing(Thing :: getNumber));
		
		// 5
		Collections.sort(lis, (t1, t2) -> { return Integer.compare(t1.getNumber(), t2.getNumber()); });
		
		System.out.println(lis.size() + " " +"Things in the List");
//		for(Thing e : lis){
//			System.out.println(e);
//		}
		
//		l.stream().sorted().forEach(System.out :: println);
		lis.forEach(System.out :: println);
	}
	
	@Override
	public String toString(){
		int number = this.getNumber();
		Integer intN = new Integer(number);
		return intN.toString();
	}

}
