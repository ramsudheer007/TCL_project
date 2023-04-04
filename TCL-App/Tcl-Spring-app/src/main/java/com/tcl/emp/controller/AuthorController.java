package com.tcl.emp.controller;

import java.util.List;

import com.tcl.emp.model.Author;
import com.tcl.emp.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorController {
	@Autowired
	private AuthService authService;
	
	@GetMapping("/authors/{firstName}")
	public ResponseEntity<?>getAllauthorsByfirstName(@PathVariable("firstName") String firstName){
		
		
		return new ResponseEntity<List<Author>>(authService.getAllAuthorByFirstName(firstName), HttpStatus.OK);
	}

	@PostMapping("/authors")
	public ResponseEntity<?>saveauthor(@RequestBody Author author){
		
		return new ResponseEntity<Author>(authService.saveAuthor(author), HttpStatus.CREATED);
	}
	
	
	
}