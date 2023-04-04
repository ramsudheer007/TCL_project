package com.tcl.emp.service;

import java.util.ArrayList;
import java.util.List;

import com.tcl.emp.model.Author;
import com.tcl.emp.model.Book;
import com.tcl.emp.repo.AuthorRepository;
import com.tcl.emp.repo.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	
	public List<Author>getAllAuthorByFirstName(String firstName){
		
		List<Author> authList=authorRepository.findByFirstName(firstName);
		return authList;
		
	}
	
	public Author saveAuthor(Author author) {
		
		List<Book>books=new ArrayList<>();
		List<Author>authors=new ArrayList<>();
		authors.add(author);
		Book book=new Book();
		book.setTitle("mango");
		book.setVersion(1);

		book.setAuthors(authors);
	Book book1=	bookRepository.save(book);
		books.add(book1);
		
		author.setBooks(books);
		
	Author auth=authorRepository.save(author);
		
		
		return auth;
		
	}
	

}
