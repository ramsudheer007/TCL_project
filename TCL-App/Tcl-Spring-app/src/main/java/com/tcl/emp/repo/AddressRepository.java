package com.tcl.emp.repo;

import com.tcl.emp.entity.EmployeeAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<EmployeeAddress, Long> {

}
