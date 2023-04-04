package com.tcl.emp.repo;

import java.util.List;

import com.tcl.emp.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> ,JpaSpecificationExecutor{

		 
	    List<Book> findByTitleContainsOrderByTitleAsc(String title);
	    
	    Page<Book> findAll(Pageable pageable);
	    
	 
	}
	

