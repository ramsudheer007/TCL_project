package com.tcl.emp.repo;

import java.util.List;

import com.tcl.emp.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
  public List<Author>findByFirstName(String firstName);
 
  public List<Author>findByFirstNameAndLastName(String firstName,String lastName);
  
  public List<Author>findByFirstNameContainingIgnoreCase(String firstName);

  public List<Author>findByBooksTitle(String title);

}
