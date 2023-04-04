package com.tcl.emp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class ValidateService {
	
	public ResponseEntity<?> validateData(BindingResult bindingResult){

		if (bindingResult.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
				break;
		}
			return new ResponseEntity<Map<String,String>>(validationsMap, HttpStatus.BAD_REQUEST);
		
	}else {
		return null;
	} 
	
	

}}
