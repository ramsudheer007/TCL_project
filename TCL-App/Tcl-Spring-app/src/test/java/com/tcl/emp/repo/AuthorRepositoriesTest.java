package com.tcl.emp.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.tcl.emp.model.Author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest()
public class AuthorRepositoriesTest {
	@Autowired
	private AuthorRepository authorRepository;
	

	
	
	@Test
	public void givenFirstName_whenFindByFirstName_thenReturnListOFAuthror() {
		//given
		String name="sunil";
		//when
		List<Author> authors=authorRepository.findByFirstName(name);
		//then
		assertThat(authors).isNotNull();
		assertThat(authors.size()).isGreaterThan(0);
		
		
	}
	
	@Test
	public void givenFirstNameAndLastName_whenFindByFirstNameAndLastName_thenReturnListOFAuthror() {
		//given
		String fName="sunil";
		String lName="yadav";
		//when
		List<Author> authors=authorRepository.findByFirstNameAndLastName(fName, lName);
		//then
		assertThat(authors).isNotNull();
		assertThat(authors.size()).isGreaterThan(0);
		
		
	}
	
	@Test
	public void givenFirstNamename_whenFindByFirstNameContainingIgnoreCase_thenReturnListOFAuthror() {
		//given
		String fName="Sunil";
		
		//when
		List<Author> authors=authorRepository.findByFirstNameContainingIgnoreCase(fName);
		//then
		assertThat(authors).isNotNull();
		assertThat(authors.size()).isEqualTo(2);
		
		
		
	}
	@Test
	public void givenBookTitle_whenFindByBookstitle_thenReturnListOFAuthror() {
		//given
		String fName="apple";
		
		//when
		List<Author> authors=authorRepository.findByBooksTitle(fName);
		//then
		        assertThat(authors).isNotNull();
				assertThat(authors.size()).isGreaterThan(0);

		
		
	}
	
	
	
	
	
	

}
