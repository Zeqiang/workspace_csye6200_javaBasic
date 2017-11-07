package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fruit {

	private int id;
	private String name;
	private double price;

	public Fruit() {
		super();
	}

	public Fruit(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public static void Demo() {

		List<Fruit> fruitList = new ArrayList<>();
		Map<Integer, Fruit> fruitmap1 = new HashMap<>();
		Map<String, Integer> fruitmap2 = new HashMap<>();
		
		Fruit fruit1 = new Fruit(3, "Strawberry", 6.51);
		Fruit fruit2 = new Fruit(9, "Blackberry", 7.73);
		Fruit fruit3 = new Fruit(1, "Apple   ", 3.89);
		Fruit fruit4 = new Fruit(5, "Pineapple", 10.15);
		Fruit fruit5 = new Fruit(2, "Pear    ", 4.20);
		Fruit fruit6 = new Fruit(8, "Cherry  ", 12.53);
		Fruit fruit7 = new Fruit(6, "Grape   ", 9.99);

		fruitList.add(fruit1);
		fruitList.add(fruit2);
		fruitList.add(fruit3);
		fruitList.add(fruit4);
		fruitList.add(fruit5);
		fruitList.add(fruit6);
		fruitList.add(fruit7);
		
		fruitmap1.put(3, fruit1);
		fruitmap1.put(9, fruit2);
		fruitmap1.put(1, fruit3);
		fruitmap1.put(5, fruit4);
		fruitmap1.put(2, fruit5);
		fruitmap1.put(8, fruit6);
		fruitmap1.put(6, fruit7);
		
		fruitmap2.put("Strawberry", 3);
		fruitmap2.put("Blackberry", 9);
		fruitmap2.put("Apple   ", 1);
		fruitmap2.put("Pineapple", 5);
		fruitmap2.put("Pear    ", 2);
		fruitmap2.put("Cherry  ", 8);
		fruitmap2.put("Grape   ", 6);
		
		// Demo executed
		System.out.println(Fruit.class.getSimpleName() + ".Demo()");
		System.out.println("----------------------------------------------------------------");
		
		// sort by Id
		System.out.println(Fruit.class.getSimpleName() + ".sortById()");
		System.out.println();
		fruitList.sort(Comparator.comparing(Fruit :: getId));
		System.out.println(fruitList.size() + " fruits in this collection");
		for(Fruit f : fruitList){
			System.out.println("ID: " + f.getId() + " Name: " + f.getName() + "	Price: " + f.getPrice());
		}
		System.out.println("----------------------------------------------------------------");
		
		// sort by Name
		System.out.println(Fruit.class.getSimpleName() + ".sortByName()");
		System.out.println();
		fruitList.sort(Comparator.comparing(Fruit :: getName));
		System.out.println(fruitList.size() + " fruits in this collection");
		for(Fruit f : fruitList){
			System.out.println("ID: " + f.getId() + " Name: " + f.getName() + "	Price: " + f.getPrice());
		}
		System.out.println("----------------------------------------------------------------");
		
		// sort by Price
		System.out.println(Fruit.class.getSimpleName() + ".sortByPrice()");
		System.out.println();
		Collections.sort(fruitList, (f1, f2) -> { return Double.compare(f1.getPrice(), f2.getPrice()); });
//		fruitList.sort(Comparator.comparing(Fruit :: getPrice));	//this can do the same
		System.out.println(fruitList.size() + " fruits in this collection");
		for(Fruit f : fruitList){
			System.out.println("ID: " + f.getId() + " Name: " + f.getName() + "	Price: " + f.getPrice());
		}
		System.out.println("----------------------------------------------------------------");
		
		// retrieve by Id
		System.out.println(Fruit.class.getSimpleName() + ".retrieveById()");
		System.out.println();
		for(Integer key : fruitmap1.keySet()){
			System.out.println("map key " + key + ", retrieve Fruit: " + fruitmap1.get(key) + "	Price : " + fruitmap1.get(key).getPrice());
		}
		System.out.println("----------------------------------------------------------------");
		
		// retrieve by Name
		System.out.println(Fruit.class.getSimpleName() + ".retrieveByName()");
		System.out.println();
		for(String key : fruitmap2.keySet()){
			System.out.println("map key " + key + "	retrieve FruitId: " + fruitmap2.get(key) + "	Price : " + fruitmap1.get(fruitmap2.get(key)).getPrice());
		}
		System.out.println("----------------------------------------------------------------");
		
	}
}
