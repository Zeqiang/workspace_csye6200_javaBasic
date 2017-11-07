package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class DemoContainer {

	public void ContainerExample() {
		System.out.println(DemoContainer.class.getSimpleName() + ".containerExample()");
		List<String> names = new ArrayList<>();

		names.add("Eric");
		names.add("Zack");
		names.add("Eve");
		Collections.sort(names, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});


		System.out.println(names.size() + " names in this collection");

		for (String name : names) {
			System.out.print(name + ", ");
		}
		System.out.println();
		System.out.println("-------------------------------------");
	}

	public void SortExample() {
		System.out.println(DemoContainer.class.getSimpleName() + ".sortExample()");
		List<Integer> numbers = new Vector<>();

		numbers.add(2);
		numbers.add(3);
		numbers.add(1);
		Collections.sort(numbers);

		System.out.println(numbers.size() + " numbers in this collection");

		for (int number : numbers) {
			System.out.print(number + ", ");
		}
		System.out.println();
		System.out.println("-------------------------------------");
	}

	public void MapExample() {
		System.out.println(DemoContainer.class.getSimpleName() + ".MapExample()");
		System.out.println("-------------------------------------");
		
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "Eric");
		m.put(5, "Albert");
		m.put(21, "Hugo");
		
		System.out.println("map key 1, retrieve Student: " + m.get(1));
		System.out.println("map key 5, retrieve Student: " + m.get(5));
		System.out.println("map key 21, retrieve Student: " + m.get(21));
		for(Integer key : m.keySet()){
			System.out.print(key + ",");
		}
		System.out.println();
		System.out.println("-------------------------------------");
	}

	public static void Demo() {

		System.out.println(DemoContainer.class.getSimpleName() + ".Demo()");
		System.out.println("-------------------------------------");
		DemoContainer dc = new DemoContainer();

		dc.ContainerExample();
		dc.SortExample();
		dc.MapExample();
	}

}
