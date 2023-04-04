package com.tcl.emp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;
	private Integer version;
	private String title;
	@ManyToMany(mappedBy = "books")
	private List<Author>authors;
	public Book(Long bid, Integer version, String title, List<Author> authors) {
		super();
		this.bid = bid;
		this.version = version;
		this.title = title;
		this.authors = authors;
	}
	public Book() {
		super();
	}
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", version=" + version + ", title=" + title + ", authors=" + authors + "]";
	}
	

}
