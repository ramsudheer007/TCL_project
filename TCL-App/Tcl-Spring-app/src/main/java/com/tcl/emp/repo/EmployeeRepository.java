package com.tcl.emp.repo;

import com.tcl.emp.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>,JpaSpecificationExecutor<Employee>{
	

}
