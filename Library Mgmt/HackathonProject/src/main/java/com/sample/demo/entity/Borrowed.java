package com.sample.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="borrowed")
public class Borrowed {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
//	@ManyToMany
	@Column(name="bookid")
	private int bookId;
	
//	@ManyToMany
	@Column(name="memberid")
	private int memberId;
	
	@Column(name="issuedate")
	private LocalDate issueDate;
	
	@Column(name="duedate")
	private LocalDate dueDate;
	
	public Borrowed() {
		
	}
	
	public Borrowed(int bookId, int memberId, LocalDate issueDate, LocalDate dueDate) {
		this.bookId = bookId;
		this.memberId = memberId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public LocalDate getIssueDate() {
		return issueDate;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}
