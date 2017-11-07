package edu.neu.csye6200;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoStreams {
	public static enum Gender {
		MALE, FEMALE
	}

	/**
	 * class SmallPerson
	 * use for sorting, nothing more
	 */
	private class InnerGuy {
		private String fName = "john";
		private String lName = "doe";
		private int age = 1;		
		private Gender gender = Gender.MALE;
		
		public InnerGuy(String fName, String lName, int age) {
			super();
			this.fName = fName;
			this.lName = lName;
			this.age = age;
		}

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getlName() {
			return lName;
		}

		public void setlName(String lName) {
			this.lName = lName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public boolean sortByAge(InnerGuy o1, InnerGuy o2) {
			return o1.getAge() < o1.getAge();
		}
		
	
		public String toString() {
			return getfName() + " " + getlName() + ", age: " + getAge();
		}
	}

	public void demoMixedStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoMixedStream()");
		Stream.of(1,2,"buckle my shoe",3,4,"shut the door",5,6).forEach(System.out::println);
		System.out.println();
		Stream.of(1,2,"buckle my shoe",3,4,"shut the door",5,6).forEach(e -> System.out.print(e + ","));
		System.out.println();
	}
	
	public void arrayStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".arrayStream()");
		int numbers[] = {1,2,3,4,5,6,7};
		IntStream numberStream = Arrays.stream(numbers);
		// forEach closes stream:is terminal operation
//		numberStream.forEach(System.out::println);
		System.out.println();
		// forEach closes stream:is terminal operation
		numberStream.forEach(n -> System.out.print(n+","));
		System.out.println();
	}
	
	public void listSream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".listSream()");
		List<String> l = new ArrayList();
		l.add("three");
		l.add("one");
		l.add("two");
		Stream<String> nameStreamFromCol = l.stream();
		nameStreamFromCol.forEach( System.out::println );
		// re-create Stream closed by forEach terminal operation
		nameStreamFromCol = l.stream();
//		nameStreamFromCol.forEach(s -> System.out.print(s + ","));
		nameStreamFromCol.filter( (s) -> s.startsWith("t") ).forEach(s -> System.out.print(s + ","));
		System.out.println();
	}
	
	public void filterSream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".filterSream()");
		List<String> l = new ArrayList();
		l.add("three");
		l.add("one");
		l.add("two");
		Stream<String> nameStreamFromCol = l.stream();
		nameStreamFromCol.forEach(s -> System.out.print(s + ","));
		System.out.println();
		// re-create Stream closed by forEach terminal operation
		nameStreamFromCol = l.stream();
		nameStreamFromCol.filter( (s) -> s.startsWith("t") ).forEach(s -> System.out.print(s + ","));
		System.out.println();
 
		nameStreamFromCol = l.stream();
		nameStreamFromCol.anyMatch( (s) -> s.startsWith("t") );
		
		nameStreamFromCol = l.stream();
		nameStreamFromCol.noneMatch( (s) -> s.startsWith("t") );
		System.out.println();
	}
	
	public void fileStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".fileStream()");
		try {
			Files.list( new File( "." ).toPath() ).forEach( System.out::println );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void demoCount() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoCount()");
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			long count = 0;
			String startingWith = "J";

			for (String name : list) {
				System.out.print(name +", ");
				if (name.startsWith(startingWith))
					++count;
			}

			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			String startingWith = "J";
			
			long count =  list.stream()
					.filter(name -> name.startsWith(startingWith))
					.count();

			list.forEach(name -> System.out.print(name +", "));
			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			String startingWith = "J";
			
			long count =  list.parallelStream()
					.filter(name -> name.startsWith(startingWith))
					.count();

			list.forEach(name -> System.out.print(name +", "));
			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			List<String> list = Arrays.asList("Jen", "Zac", "Dan");
			list.forEach(System.out::print);
			System.out.println(list.size() + " elements in above list.");
		}
	}
	
	/**
	 * showList generic method for numbered output of collections of various type elements
	 * 
	 * @param title		Output title string
	 * @param l			Collection for output
	 */
	public <T> void showList(String title, List<T> l) {
		System.out.println(l.size() + title);
		int i = 1;		// 1 based numbering of elements
		for (T n : l) {
			System.out.print(i + ". " + n + " ");
			i++;
		}
		System.out.println();
	}

	public void process(List<Integer> numbers) {
		System.out.println(DemoStreams.class.getSimpleName() + ".process()");
//		numbers.add(70);	// can't add to fixed size list backed by array
//		numbers.parallelStream()	// sort is funny
		numbers.stream()
		.map(n-> n*10)
//		.map(n-> n-3)
		.sorted()
		.forEach(n-> System.out.print(n +", "));
		System.out.println(numbers.size() + " elements in container");
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoSumSquares() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoSumSquares()");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Integer totalSum = numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .mapToInt(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       .sum();
		System.out.println("DemoStreams.demoSumSquares() = " + totalSum);
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoReduceSquares() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoReduceSquares()");

		// https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Integer totalSum = numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .mapToInt(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       // (identity/default/init, accumulator algorithm)
		       .reduce(0, (a,b) -> a + b);
		System.out.println("DemoStreams.demoReduceSquares() = " + totalSum);
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoCollect() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoCollect()");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> collectedTwoEvenSquares = 
		    numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .map(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       .collect(Collectors.toList());
		System.out.println(DemoStreams.class.getName() + ".demoCollect() = " + collectedTwoEvenSquares);
	}

	public void sortInnerGuy() {
		System.out.println(DemoStreams.class.getSimpleName() + ".sortInnerGuy()");
		{
			List<InnerGuy> l = new ArrayList<>();
			l.add(new InnerGuy("john", "adams", 72));
			l.add(new InnerGuy("ben", "franklin", 62));
			l.add(new InnerGuy("george", "washington", 69));
			l.stream().forEach(n -> System.out.print(n + ", "));
			System.out.println(l.size() + " unsorted elements in list");
			Collections.sort(l, Comparator.comparing(InnerGuy::getAge));
			l.stream().forEach(n -> System.out.print(n + ", "));
			System.out.println(" " + DemoStreams.class.getName() + " sortInnerPerson() - " + l.size()
					+ " age sorted elements in list");
		}
		{
//			DemoContainer d = new DemoContainer();
			List<InnerGuy> l = new ArrayList<>();
			l.add(new InnerGuy("john", "adams", 72));
			l.add(new InnerGuy("ben", "franklin", 62));
			l.add(new InnerGuy("george", "washington", 69));
			l.stream().forEach(n -> System.out.print(n + ", "));
			System.out.println(l.size() + " unsorted elements in list");
			l.stream()
					// .sorted(Comparator.comparing(InnerGuy::getlName))
					.sorted(Comparator.comparing(InnerGuy::getfName))
					// .sorted(Comparator.comparing(InnerGuy::getAge))
					.forEach(n -> System.out.print(n + ", "));
			System.out.println(" " + DemoStreams.class.getName() + " sortInnerPerson() - " + l.size()
					+ " first name sorted elements in list");
		}
	}
	
	public void partitionStream() {
		System.out.println("\n\n" + DemoStreams.class.getSimpleName() + ".partitionStream()");
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		int threshold = 3;
		Map<Boolean, List<Integer>> parts = numbers.stream().collect(Collectors.partitioningBy(n -> n > threshold ));
		System.out.println("Partition Numbers exceeding threshold of " + threshold + "\n"
				+ numbers + " => \n"
				+ "    True: " + parts.get(true) + " \n"
				+ "   False: " + parts.get(false) + "\n");
	}
	
	public static void demo () {
		System.out.println("\n\n" + DemoStreams.class.getSimpleName() + ".demo()");
		DemoStreams obj = new DemoStreams();
		obj.demoMixedStream();
		obj.arrayStream();
		obj.listSream();
		obj.fileStream();
		obj.filterSream();
		obj.demoCount();
		obj.demoSumSquares();
		obj.demoReduceSquares();
		obj.demoCollect();
		obj.process(Arrays.asList(8,2,4,5,7,6,1,9,3));
		obj.sortInnerGuy();
//		obj.process(new ArrayList<Integer>(Arrays.asList(8,2,4,5,7,6,1,9,3)));
		obj.partitionStream();
		
	}
}
