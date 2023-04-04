package com.tcl.emp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tcl.emp.dto.EmployeeSpecification;
import com.tcl.emp.dto.ResponseDto;
import com.tcl.emp.entity.Employee;
import com.tcl.emp.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class EmployeeFilterSearch {

	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getSpecification(ResponseDto dto) {

		Specification spec = new Specification() {
			@Override
			public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get(dto.getColumnName()), dto.getValue());
			}
		};

		return empRepository.findAll(spec);

	}

	

	public List<Employee> getSpecificationlists(List<ResponseDto> dtolist,String gOprator) {

		List<Predicate> predicteList = new ArrayList<>();
		Specification spec = new Specification() {
			@Override
			public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
				for (ResponseDto dto : dtolist) {
					
					switch (dto.getLocalOprator()) {
						case "EQUAl":
							Predicate pdtPredicate = criteriaBuilder.equal(root.get(dto.getColumnName()), dto.getValue());
							predicteList.add(pdtPredicate);
							break;
						case "LIKE":
							Predicate like = criteriaBuilder.like(root.get(dto.getColumnName()),"%"+ dto.getValue()+"%");
							predicteList.add(like);
							break;
						case "IN":
							String[] split=dto.getValue().split(",");
						  Predicate inPredicate=root.get(dto.getColumnName()).in(Arrays.asList(split));
						  predicteList.add(inPredicate);
							break;
						case "BETWEEN":
							String[] split1=dto.getValue().split(",");
						Predicate between=	criteriaBuilder.between(root.get(dto.getColumnName()), split1[0], split1[1]);
						  predicteList.add(between);
							break;
						case "GREATER_THAN":
							Predicate greaterthan = criteriaBuilder.greaterThan(root.get(dto.getColumnName()), dto.getValue());
							predicteList.add(greaterthan);
					        break;
						case "LESS_THAN":
							Predicate lessThan = criteriaBuilder.lessThan(root.get(dto.getColumnName()), dto.getValue());
							predicteList.add(lessThan);
					        break;
						case "JOIN":
						Predicate joinTable=criteriaBuilder.equal(root.join(dto.getJoinTable()).get(dto.getColumnName()),dto.getValue());
							predicteList.add(joinTable);
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " );
					}
				}
			
				if(gOprator.equals("AND")) {
						return criteriaBuilder.and(predicteList.toArray(new Predicate[0]));
				}else {
					return criteriaBuilder.or(predicteList.toArray(new Predicate[0]));
				}
			
			}
		
			};
		return empRepository.findAll(spec);
		
	}	

}
