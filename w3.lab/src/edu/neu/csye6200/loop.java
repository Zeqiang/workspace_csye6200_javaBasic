package edu.neu.csye6200;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

public class loop {

	public static void main(String[] args) {
		
		
//		String[] names = {"Adam","Eve","Cain","Able"};		
//		for(String name : names){
//			System.out.println(name);
//		}
		
		
//		ArrayList<String> col = new ArrayList<String>();
//		col.add("Peter");
//		col.add("Paul");
//		col.add("Mary");		
//		for (String item : col) {
//			System.out.println(item);
//		}
		

//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//		numbers.add(1);
//		numbers.add(2);
//		numbers.add(3);
//		Iterator<Integer> it = numbers.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}
		

//		ArrayList<String> names= new ArrayList<String>();
//		names.add("Peter");
//		names.add("Paul");
//		names.add("Mary");
//		Iterator<String> it = names.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}

		
//		ArrayList<String> names= new ArrayList<String>();
//		names.add("Peter");
//		names.add("Paul");
//		names.add("Mary");
//		ListIterator<String> it = names.listIterator();
//		while (it.hasNext()) {
//			String item = it2.next();
//			item = item.toUpperCase() + ", ";
//			it2.set(item);  // only in ListIterator
//			System.out.print(it2.next() +", ");
//		}
		
		
//		List<String> numbers= new ArrayList<String>();
//		numbers.add(1);
//		numbers.add(2);
//		numbers.add(3);
//		ListIterator<Integer> it = numbers.listIterator();
//		while (it.hasNext()) {
//			System.out.print(it.next() +", ");
//		}


//		int[] numbers = { 1,2,3 };
//		for (int number : numbers ) {
//			System.out.print(number +", ");
//		}

//		int[] numbers = { 1,2,3 };
//		for (int number : numbers ) {
//			System.out.print(number +", ");
//		}
		
		
//		Map<String, String> states = new HashMap<String, String>();
//		states.put("NH", "New Hampshire");
//		states.put("NJ", "New Jersey");
//		states.put("NY", "New York");
//		System.out.println("NY: " + states.get("NY"));
//		System.out.println("NJ: " + states.get("NJ"));


//		Student dan = new Student();
//		Scanner in = new Scanner("peters,dan,17,3.25,james,peters");
//		in.useDelimiter(",");
//		dan.setLname(in.next());
//		dan.setFname(in.next());
//		dan.setAge(in.nextInt());
//		dan.setGpa(in.nextDouble());
//		dan.setParentFname(in.next());
//		dan.setParentLname(in.next());
//		in.close();
//		students.add(dan);
//		System.out.println(students.size() + " Students in roster.");
//		for (Student student : students) {
//			System.out.println(student.getLname()
//				+ ", " + student.getFname()
//				+", Age " + student.getAge()
//				+", GPA: " + student.getGpa());
//		}
		

//		String  thisLine = null;
//		// try with resources: all resources in () are closed at conclusion of try clause
//		try (
//			// open input stream from input file for reading purpose.
//			FileReader fr = new FileReader("fileName");
//			BufferedReader in = new BufferedReader(fr);)
//		{
//			System.out.println("BufferedReader: '" + fr.getEncoding() + "'");
//			while ((thisLine = in.readLine()) != null) {
//				System.out.println(thisLine);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}

		
		String[] fiveNames = {"Dan", "Jim", "Eve", "Ina"};
		// try with resources: all resources in () are closed at conclusion of try clause
		try (	// open output stream to output file for writing purpose.
			FileWriter fw = new FileWriter("fileName");
			BufferedWriter out= new BufferedWriter(fw);
			) {
		       System.out.println("BufferedWriter: '" + this.outputFileName + "', write " + fiveNames.length + " items");
			for (String name : fiveNames) {
				out.write(name);
				out.newLine();
			}
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		//try with resources: 
//		//all resources in () are closed at conclusion of try clause
//		try (	// open output stream to output file for writing.
//			FileWriter fw = new FileWriter("fileName");
//			BufferedWriter out= new BufferedWriter(fw);  
//		   ) {
//			for (String name : fiveNames) {
//				out.write(name);
//				out.newLine();
//			}
//			out.flush();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
		

	}

}
