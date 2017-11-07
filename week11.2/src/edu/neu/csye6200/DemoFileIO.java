package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DemoFileIO {
	private static final String DEFAULT_STUDENT_FILENAME = "students.txt";
	static final String DEFAULT_INPUT_FILENAME = "input.txt";
	static final String DEFAULT_OUTPUT_FILENAME = "output.txt";
	String inputFileName;
	String outputFileName;

	public DemoFileIO() {
		this.inputFileName = DEFAULT_INPUT_FILENAME;
		this.outputFileName = DEFAULT_OUTPUT_FILENAME;
	}

	public DemoFileIO(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}
	
	public void useStringSplit() {
		final String s = new String("peters,dan,17,3.25,james,peters");
		
		String [] fields = null;
		
		fields = s.split(",");
		System.out.println(fields.length + " elements in container.");
		for (String f : fields) {
			System.out.print(f + ",");
		}
		System.out.println();
	}
	
	public void useScanner() {
		List<Student> students = new ArrayList<Student>();
		
		Student dan = new Student();

		Scanner in = new Scanner("peters,dan,17,3.25,james,peters");
		in.useDelimiter(",");

		dan.setLname(in.next());
		dan.setFname(in.next());
		dan.setAge(in.nextInt());
		dan.setGpa(in.nextDouble());
		dan.setParentFname(in.next());
		dan.setParentLname(in.next());
		in.close();
		students.add(dan);

		// show collection
		System.out.println(students.size() + " Students in roster.");
		for (Student student : students) {
			System.out.println(
					student.getLname()
					+ ", " + student.getFname()
					+", Age " + student.getAge()
					+", GPA: " + student.getGpa()
					);
		}
		System.out.println();
	}

	public List<Student> readStudentRoster(String fileName) {
		System.out.println(DemoFileIO.class.getSimpleName() +".readStudentRoster:");
		List<Student> students = new ArrayList<Student>();

		// try with resources: all resources in () are closed at conclusion of try clause
		try (BufferedReader inLine = new BufferedReader(new FileReader(fileName))) {
			String inputLine = null;
			while ((inputLine = inLine.readLine()) != null) {
				String[] fields = inputLine.split(",");
				String lname = fields[0];
				String fname = fields[1];
				int age = new Integer(fields[2]);
				double gpa = new Double(fields[3]);
				String parentFname = fields[4];
				String parentLname = fields[5];
								
				students.add(new Student (fname,lname,age,gpa,parentFname,parentLname));
			}
		} catch (IOException e) {
			// catch IOException (and implicitly FileNotFoundException)
			e.printStackTrace();
		}
		// show collection
		System.out.println(students.size() + " Students in roster.");
		for (Student student : students) {
			System.out.println(
					student.getLname()
					+ ", " + student.getFname()
					+", Age " + student.getAge()
					+", GPA: " + student.getGpa()
					);
		}
		System.out.println();

		return students;
	}


	public List<Student> readStudentRosterScanner(String fileName) {
		System.out.println(DemoFileIO.class.getSimpleName() +".readStudentRosterScanner:");
		List<Student> students = new ArrayList<Student>();

		try {
			Scanner inLine = new Scanner(new BufferedReader(new FileReader(fileName)));
			
			while (inLine.hasNextLine()) {
				String inputLine = inLine.nextLine();
				Scanner in = new Scanner(inputLine);
				in.useDelimiter(",");
				String lname = in.next();
				String fname = in.next();
				int age = in.nextInt();
				double gpa = in.nextDouble();
				String parentFname = in.next();
				String parentLname = in.next();
								
				students.add(new Student (fname,lname,age,gpa,parentFname,parentLname));
				in.close();
			}
			inLine.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// show collection
		System.out.println(students.size() + " Students in roster.");
		for (Student student : students) {
			System.out.println(
					student.getLname()
					+ ", " + student.getFname()
					+", Age " + student.getAge()
					+", GPA: " + student.getGpa()
					);
		}
		System.out.println();

		return students;
	}
	
	public List<Student> useStudentRoster() {
		System.out.println(DemoFileIO.class.getSimpleName() +".useStudentRoster:");
		List<Student> students = new ArrayList<Student>();
		
		Student drew = new Student();

		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader(DEFAULT_STUDENT_FILENAME)));
			in.useDelimiter(",");
			
			while (in.hasNext()) {
				drew.setLname(in.next());
				drew.setFname(in.next());
				drew.setAge(in.nextInt());
				drew.setGpa(in.nextDouble());
				drew.setParentFname(in.next());
				drew.setParentLname(in.next());
				break;
			}
			in.close();
			students.add(drew);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// show collection
		System.out.println(students.size() + " Students in roster.");
		for (Student student : students) {
			System.out.println(
					student.getLname()
					+ ", " + student.getFname()
					+", Age " + student.getAge()
					+", GPA: " + student.getGpa()
					);
		}
		System.out.println();

		return students;
	}
	
	public void useCommand(String cmd) {
		System.out.println(DemoFileIO.class.getSimpleName() + ".useCommand('" + cmd + "')");
	    String line;
  
	    OutputStream stdin = null;
	    InputStream stderr = null;
	    InputStream stdout = null;

	      try {
			// launch EXE and grab stdin/stdout and stderr
			  Process process = Runtime.getRuntime ().exec (cmd);
			  stdin = process.getOutputStream ();
			  stderr = process.getErrorStream ();
			  stdout = process.getInputStream ();
//			  // "write" the parms into stdin
//			  line = "param1" + "\n";   
//			  stdin.write(line.getBytes() );
//			  stdin.flush();
//
//			  line = "param2" + "\n";
//			  stdin.write(line.getBytes() );
//			  stdin.flush();
//
//			  line = "param3" + "\n";
//			  stdin.write(line.getBytes() );
//			  stdin.flush();

			  stdin.close();
			  
			  // clean up if any output in stdout
			  BufferedReader brCleanUp = 
			    new BufferedReader (new InputStreamReader (stdout));
			  while ((line = brCleanUp.readLine ()) != null) {
			    System.out.println ("[Stdout] " + line);
			  }
			  brCleanUp.close();
			  
			  // clean up if any output in stderr
			  brCleanUp = 
			    new BufferedReader (new InputStreamReader (stderr));
			  while ((line = brCleanUp.readLine ()) != null) {
			    System.out.println ("[Stderr] " + line);
			  }
			  brCleanUp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(
					this.getClass().getSimpleName() +": "
					+ "ERROR: '"
					+ e.getMessage() + "'");
			e.printStackTrace();
		}
		
	}


	public void useBasicBufferedReader(String fileName) {		
	      String  thisLine = null;
	      BufferedReader in = null;
	    	      try{
	    	         // open input stream from input file for reading purpose.
	    	         in = new BufferedReader(new FileReader(fileName));
	    	         System.out.println("BufferedReader: '" + fileName + "'");
	    	         while ((thisLine = in.readLine()) != null) {
	    	            System.out.println(thisLine);
	    	         }
	    	         in.close();
	    	      }catch(Exception e){
	    	         e.printStackTrace();
	    	      }
	}
	
	public void useBufferedReader() {		
	      String  thisLine = null;
	      BufferedReader in = null;
	    	      try{
	    	         // open input stream from input file for reading purpose.
	    	         in = new BufferedReader(new FileReader(this.inputFileName));
	    	         System.out.println("BufferedReader: '" + this.inputFileName + "'");
	    	         while ((thisLine = in.readLine()) != null) {
	    	            System.out.println(thisLine);
	    	         }
	    	         in.close();
	    	      }catch(Exception e){
	    	         e.printStackTrace();
	    	      }
	}
	
	public void useBasicBufferedWriter() {
		String[] names = {"James", "Wayne", "Jane"};		
	
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
	         // open output stream to output file for writing purpose.
			fw = new FileWriter(this.outputFileName);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
	        System.out.println("BufferedWriter: '" + this.outputFileName + "', write " + names.length + " items");
			for (String name : names) {
				out.println(name);
				System.out.print(name + ", ");
			}
			System.out.println();
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void useBufferedWriter() {
		List<String> names = new ArrayList<String>();		
		names.add("David");
		names.add("Ina");
		names.add("Adam");
		
		BufferedWriter out = null;
		try {
	         // open output stream to output file for writing purpose.
			out = new BufferedWriter(new FileWriter(this.outputFileName));
	        System.out.println("BufferedWriter: '" 
			+ this.outputFileName + "', write " 
			+ names.size() + " items");
			for (String name : names) {
				out.write(name);
				out.newLine(); // use next line for next output
				System.out.print(name + ", ");
			}
			System.out.println();
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void useBufferedWriter2() {
		String[] threeBoys = {"Billy", "Jimmy", "Timmy"};
		List<String> boyNames = new ArrayList<String>(Arrays.asList(threeBoys));

		String[] threeGirls = new String[3];
		threeBoys[0] = "Sally";
		threeBoys[0] = "Jessie";
		threeBoys[0] = "Evie";
		List<String> girlNames = new ArrayList<String>(Arrays.asList(threeGirls));
		
		List<String> names = new ArrayList<String>();		
		names.add("David");
		names.add("Ina");
		names.add("Adam");
		
		names.addAll(girlNames);
		names.addAll(boyNames);
		
//		PrintWriter out = null;
		BufferedWriter out = null;
		try {
	         // open output stream to output file for writing purpose.
			out = new BufferedWriter(new FileWriter(this.outputFileName));
	        System.out.println("BufferedWriter: '" 
			+ this.outputFileName + "', write " 
			+ names.size() + " items");
			for (String name : names) {
				out.write(name);
				out.newLine();
			}
			
			
//	         // open output stream to output file for writing purpose.
//			out = new PrintWriter(new BufferedWriter(new FileWriter(this.outputFileName)));
//	        System.out.println("BufferedWriter: '" 
//			+ this.outputFileName + "', write " 
//			+ fiveNames.length + " items");
//			for (String name : fiveNames) {
//				out.println(name);
//			}
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int copyBytes() throws IOException {
		int status = 0;
		// TODO Auto-generated constructor stub
		// Java Byte Streams: Java File Stream reads 8-bit bytes
		// (not to be confused with characters)
		FileInputStream fin = null;
		FileOutputStream fout = null;

		try {
			fin = new FileInputStream(inputFileName);
			fout = new FileOutputStream(outputFileName);

			// loop to read (an) entire contents of input file
			int c;
			while ((c = fin.read()) != -1) {
				fout.write(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(this.getClass().getName() + ": '" + e.getMessage() + "'");
			status = -1;
			return status;
		} finally {
			// TODO: handle finally clause
			fin.close();
			fout.close();
		}
		return status;
	} // end copyBytes() method

	public int copyUnicodeChars() throws IOException {
		int status = 0;
		// TODO Auto-generated constructor stub
		// Java Character Streams: Java File Reader reads 16-bit Unicode characters
		// (not to be confused with 8-bit bytes)
		FileReader fin = null;
		FileWriter fout = null;

		try {
			fin = new FileReader(inputFileName);
			fout = new FileWriter(outputFileName);

			// loop to read (an) entire contents of input file
			int c;
			while ((c = fin.read()) != -1) {
				fout.write(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(this.getClass().getName() + ": '" 
			+ e.getMessage() + "'");
			status = -1;
			return status;
		} finally {
			// TODO: handle finally clause
			fin.close();
			fout.close();
		}
		return status;
	} // end copyUnicodeChars() method
	
	public static void demo() {
		System.out.println("\n\n" + DemoFileIO.class.getName() +".demo...");
		DemoFileIO obj = new DemoFileIO();
		
//		obj.useBasicBufferedWriter();
//		obj.useBasicBufferedReader(DEFAULT_OUTPUT_FILENAME);
//		obj.useBufferedWriter();
//		obj.useBasicBufferedReader(DEFAULT_OUTPUT_FILENAME);
//
//		obj.useStringSplit();
//		
//		obj.readStudentRoster(DEFAULT_STUDENT_FILENAME);
//		obj.readStudentRosterScanner(DEFAULT_STUDENT_FILENAME);
//		obj.useStudentRoster();
		
		// [Stdout] /Users/danielgmp/Documents/workspace-neon-java1-test1/Driver
		obj.useCommand("java");					// display project directory
		obj.useCommand("java Cmd1");			// execute 'Cmd1' in project directory
		obj.useCommand("java Cmd1 Cmd1Argument1");	// execute 'Cmd1' in project directory
		obj.useCommand("java -cp Cmd1b Cmd1");			// execute 'Cmd1' in project directory
		obj.useCommand("java -cp Cmd1b Cmd1 Cmd1bArgument1");	// execute 'Cmd1' in project directory
		obj.useCommand("java -jar Cmd1.jar Cmd1JarArgument1");	// execute 'Cmd1' in project directory
		obj.useCommand("demo1v/demo1");			// execute './demo1/demo' C++ program in project directory
//		StringBuilder cmdLine = new StringBuilder();
//		cmdLine.append("java");					// directory holding class files
//		cmdLine.append(" -cp bin ");			// directory holding class files
//		cmdLine.append(" edu.sti.java1.Dog ");	// full name with package
//		obj.useCommand(cmdLine.toString());
//		cmdLine.setLength(0);
//		cmdLine.append("java");					// directory holding class files
//		cmdLine.append(" -cp bin ");			// directory holding class files
//		cmdLine.append(" edu.sti.java1.Animal ");	// full name with package
//		obj.useCommand(cmdLine.toString());
	}

}
