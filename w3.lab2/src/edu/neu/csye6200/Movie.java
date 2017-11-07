package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Movie {
	
	int movieID;
	String movieName;
	String description;
	double price;
	double score;
	
	// default constructor
	public Movie() {
		super();
	}

	// overload constructor
	public Movie(int movieID, String movieName, String description, double price, double score) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		this.description = description;
		this.price = price;
		this.score = score;
	}

	// getter&setter methods
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	// BufferedWriter methods
	public static void demo_writter(){
		
		String[] fourMovies = {"1,Dog's Purpose ,A dog looks to discover his purpose in life                ,14.5,1.5" , 
							   "2,Arrival       ,Twelve mysterious spacecraft appear around the world       ,16.5,6.5" , 
							   "3,La La Land    ,A jazz pianist falls for an aspiring actress in Los Angeles,15.5,8.5" , 
							   "4,Hidden Figures,A team of women launch the first space mission             ,15.5,8.5"};
		
		try(BufferedWriter br = new BufferedWriter(new FileWriter("MovieList.csv")))
		{
			System.out.println("BufferedWriter Excuted Successfully");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("BufferedWriter: 'MovieList.csv' has " + fourMovies.length + " items");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			for (String name : fourMovies) {
				br.write(name);
				br.newLine();
			}
			br.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// BufferedReader methods
	public static void demo_reader(){
		
		List<Movie> movieList = new ArrayList<Movie>();
		
		try(BufferedReader inLine = new BufferedReader(new FileReader("MovieList.csv")))
		{
			String inputLine = null;
			
			System.out.println("BufferedReader : 'MovieList.csv' read successfully");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("Movie ID	" + "Movie Name	" + "Description							" + "Price	" + "Score	");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			
			while ((inputLine = inLine.readLine()) != null) {
				
				String[] fields = inputLine.split(",");
				int movieID = new Integer(fields[0]);
				String movieName = fields[1];
				String description = fields[2];
				double price = new Double(fields[3]);
				double score = new Double(fields[4]);
				
				Movie movie = new Movie (movieID,movieName,description,price,score);
				movieList.add(movie);
				
				System.out.println(movie.getMovieID() + "		" + movie.getMovieName() + "	" + movie.getDescription() + "	" + movie.getPrice() + "	" + movie.getScore());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
