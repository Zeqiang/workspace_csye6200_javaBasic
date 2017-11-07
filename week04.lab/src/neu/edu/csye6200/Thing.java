package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class Thing implements Comparable<Thing>, Runnable{
	
	private String cha;

	public Thing() {
		super();
	}

	public Thing(String cha) {
		super();
		this.cha = cha;
	}
	
	public void task(){
		System.out.println("Task Starting...");
		
		List<Thing> list = new ArrayList<>();
		list.add(new Thing("c"));
		list.add(new Thing("a"));
		list.add(new Thing("b"));
		
		
	}
	
	@Override
	public void run() {
		System.out.println("Runing ...");
		this.task();
	}
	
	@Override
	public int compareTo(Thing obj) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Thing []";
	}

	public static void demo(){
		
	}
	
	public int compare(Object o1, Object o2) {
        Product product1 = (Product) o1;
        Product product2 = (Product) o2;
        if(product1.getFloorPrice() > product2.getFloorPrice()){
            return 1;
        }else if(product1.getFloorPrice() == product2.getFloorPrice()){
            return 0;
        }
        return -1;
    }
}
