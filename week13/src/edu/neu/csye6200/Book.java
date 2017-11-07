package edu.neu.csye6200;

public class Book {

	private String title;
	private String author;
	private Person borrower;
	
	public Book() {
		super();
	}

	public Book(String title, String author, Person borrower) {
		super();
		this.title = title;
		this.author = author;
		this.borrower = borrower;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Person getBorrower() {
		return borrower;
	}

	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}
	
	@Override
	public String toString() {
		return this.getTitle() + "-" + this.getAuthor() + "-" + this.getBorrower();
	}
}
