package edu.neu.csye6200;

import java.util.Arrays;
import java.util.List;

public class test {

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
	

	public static void printList(List<?> list) { 
	      for (Object elem: list) 
	          System.out.print(elem + " "); 
	      System.out.println(); 
	  } // end printList
	
	
	public static double sumOfList(List<? extends Number> list) { 
		  double s = 0.0; 
		  for (Number n : list) 
		      s += n.doubleValue();
		  return s; 
	}
	
	public static void addNumbers(List<? super Integer> list) { 
	      for (int i = 1; i <= 10; i++) { 
	          list.add(i); 
	      } // end for
	  } // end addNumbers

	
	public static void demo(){
		
		List<Integer> i = Arrays.asList(1, 2, 3);
		System.out.println("sum = " + sumOfList(i));
		
		List<Double> d = Arrays.asList(1.2, 2.3, 3.5); 
		System.out.println("sum = " + sumOfList(d));

	}
	
}
