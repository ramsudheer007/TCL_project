package com.tcl.emp.controller;

import java.util.List;

import com.tcl.emp.dto.EmployeeDto;
import com.tcl.emp.dto.RequestFilterSearch;
import com.tcl.emp.entity.Employee;
import com.tcl.emp.service.EmployeeFilterSearch;
import com.tcl.emp.service.EmployeeServiceImpl;
import com.tcl.emp.service.ValidateService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tcl")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl impl;
	@Autowired
	private ValidateService service;

	@Autowired
	private EmployeeFilterSearch efs;
	
	private static  Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping("/employees")
	public ResponseEntity<?> saveEmployee(@Validated @RequestBody EmployeeDto dto, BindingResult bindingResult) {

		logger.debug("User Data is validating ", dto.getAltMobileNo());
		
		if (service.validateData(bindingResult) != null) {
			return service.validateData(bindingResult);

		} else {
			return new ResponseEntity<EmployeeDto>(impl.saveEmployee(dto), HttpStatus.CREATED);
		}

	}

	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "1", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "emp_id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {

		return new ResponseEntity<List<EmployeeDto>>(impl.getAllEmployees(pageNo, pageSize, sortBy, sortDir),
				HttpStatus.OK);

	}

	@DeleteMapping("/employees/{empid}")
	public ResponseEntity<?> deleteById(@PathVariable("empid") Long empid) {
		impl.deleteEmployee(empid);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	public ResponseEntity<?> getEmployeeByName(@PathVariable String name) {
		return null;

	}

	@PutMapping("/employees/{emp_id}")
	public ResponseEntity<?> updateEmployee(@Validated @PathVariable("emp_id") Long emp_id,
			@RequestBody EmployeeDto eDto, BindingResult bindingResult) {
		if (service.validateData(bindingResult) != null) {
			return service.validateData(bindingResult);

		} else {
			return new ResponseEntity<EmployeeDto>(impl.updatEmployee(eDto, emp_id), HttpStatus.CREATED);
		}
	}

//	@GetMapping("/employees/{empColumn}/{empValue}")
//	public ResponseEntity<?> getAllEmployessByName(@PathVariable String empColumn, @PathVariable String empValue) {
//
//		List<Employee> empList = efs.getSpecification(empColumn, empValue);
//
//		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
//
//	}
//	@PostMapping("/employees/filterResponse")
//	public ResponseEntity<?> getAllEmployessByName(@RequestBody ResponseDto dto) {
//
//		List<Employee> empList = efs.getSpecification(dto.getColumnName(),dto.getValue());
//
//		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
//
//	}

	@GetMapping("/employees/{empid}")

	public ResponseEntity<?> getEmployeeById(@PathVariable("empid") Long empid) {

		return new ResponseEntity<EmployeeDto>(impl.getEmployeeById(empid), HttpStatus.OK);

	}
	@PostMapping("/employees/responseList")
	public ResponseEntity<?> getAllEmployessByNameAndAge(@RequestBody RequestFilterSearch rfsDto) {

		List<Employee> empList = efs.getSpecificationlists(rfsDto.getDtoList(),rfsDto.getGlobalOprator());

		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

	}
	
	
	

}
