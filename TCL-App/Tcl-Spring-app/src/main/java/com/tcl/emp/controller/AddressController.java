package com.tcl.emp.controller;

import com.tcl.emp.dto.AdresssDto;
import com.tcl.emp.service.AddressServiceIml;
import com.tcl.emp.service.ValidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tcl")
public class AddressController {
	@Autowired
	private ValidateService service;
	
	@Autowired
	private AddressServiceIml serviceIml;
	
	@PostMapping("/employees/{emp_id}/address")
	public ResponseEntity<?>saveEmpAddress(@Validated @PathVariable("emp_id") Long id,@RequestBody AdresssDto dto,BindingResult bindingResult){

		if (service.validateData(bindingResult) != null) {
			return service.validateData(bindingResult);

		} else {
			return new ResponseEntity<AdresssDto>(serviceIml.saveAddress(dto, id), HttpStatus.CREATED);
		}

		
}
	@PutMapping("/employees/{emp_id}/address/{add_id}")
	public ResponseEntity<?>updateaddressOfEmployee(@Validated 
			@PathVariable("emp_id")Long emp_id,
			@PathVariable("add_id")Long add_id,
			@RequestBody AdresssDto dto,BindingResult  bindingResult){
		
		
		if (service.validateData(bindingResult) != null) {
			return service.validateData(bindingResult);

		} else {
			return new ResponseEntity<AdresssDto>(serviceIml.updateAddressOfEmp(emp_id,add_id,dto), HttpStatus.CREATED);
		}

		
		
	}
}