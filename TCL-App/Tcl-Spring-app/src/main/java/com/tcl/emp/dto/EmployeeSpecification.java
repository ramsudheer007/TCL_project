package com.tcl.emp.dto;

import com.tcl.emp.entity.Employee;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmployeeSpecification implements Specification<Employee>{
	
	private ResponseDto dto;

	public EmployeeSpecification(ResponseDto dto){
		this.dto = dto;
	}
	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return criteriaBuilder.equal(root.get(dto.getColumnName()), dto.getValue());
	}

}
