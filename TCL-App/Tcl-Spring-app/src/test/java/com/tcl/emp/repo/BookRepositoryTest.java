package com.tcl.emp.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.tcl.emp.model.Book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	@Test
	public void testfindByTitleContainsOrderByTitleAsc() {
		//given
		String title="apple";
		//when
		List<Book> books=repository.findByTitleContainsOrderByTitleAsc(title);
	
		
		System.out.println();
		//then
		assertThat(books).isNotNull();
		assertThat(books.size()).isGreaterThan(0);
		assertThat(books.get(0).getTitle()).isEqualTo("apple");
		
	}
	@Test
	public void givenSizeAndPage_whenFindAllPageable_thenReturnListOfBooks() {
		
		Pageable pageable=PageRequest.of(0, 3);
		
	Page<Book> pages=repository.findAll(pageable);
	
	Assertions.assertThat(pages).isNotNull();
	assertThat(pages.getSize()).isEqualTo(3);
		
	}
	
	
	
	

}
