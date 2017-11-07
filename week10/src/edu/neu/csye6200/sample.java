package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sample {
	
	public static void demo(){
		
		List<Integer>  numbers = new ArrayList<>(Arrays.asList(3,2,7,4,5,1,6));
		numbers.stream().sorted().forEach(System.out :: println);

//		Collections.sort(numbers, (n1,n2) -> { return Integer.compare(n1, n2); });
//		Collections.sort(numbers, (n1,n2) -> { return n1 > n2 ? 1 : -1; }  );
//		Collections.sort(numbers, (n1,n2) -> { return Integer.compare(n1, n2); });
//		Collections.sort(numbers, (Integer n1, Integer n2) -> Integer.compare(n1, n2));
		numbers.forEach(n -> System.out.print(n + " "));
	}
}
