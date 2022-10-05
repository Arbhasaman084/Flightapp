package com.sample.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	@Id
	@Column(name="bookid")
	private int bookId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private double price;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="availability")
	private boolean availability;
	
	public Books() {
		
	}
	
	public Books(int bookId, String title, double price, String genre, boolean availability) {
		this.bookId=bookId;
		this.title = title;
		this.price = price;
		this.genre = genre;
		this.availability = availability;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean isAvailability() {
		return availability;
	}
	
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
	return "Book [Id: " + bookId + ", Title: " + title + ", Price: " + price + ", Genre"
			+ genre + ", Available? " + availability + "]";
	}
}
