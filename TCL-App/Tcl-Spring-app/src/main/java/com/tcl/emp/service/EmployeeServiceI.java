package com.tcl.emp.service;

import java.util.List;

import com.tcl.emp.dto.EmployeeDto;

public interface EmployeeServiceI {
	
	
	public EmployeeDto saveEmployee(EmployeeDto empDto);
	
	public List<EmployeeDto> getAllEmployees(int pageNo,int pageSize,String sortBy,String sortDir);
	
	public void deleteEmployee(Long emp_id);
	
	

	public EmployeeDto updatEmployee(EmployeeDto empDto, Long id);

}
