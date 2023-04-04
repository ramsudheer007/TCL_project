package com.tcl.emp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer version;
	private String firstName;
	private String lastName;
	@ManyToMany
	@JoinTable(
			  name = "auth_books", 
			  joinColumns = @JoinColumn(name = "bid"), 
			  inverseJoinColumns = @JoinColumn(name = "id"))
	private List<Book>books;
	public Author(Long id, Integer version, String firstName, String lastName, List<Book> books) {
		super();
		this.id = id;
		this.version = version;
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}
	public Author() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", books=" + books + "]";
	}
	
	
}
