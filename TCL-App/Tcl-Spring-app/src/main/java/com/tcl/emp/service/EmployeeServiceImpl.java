package com.tcl.emp.service;

import java.util.ArrayList;
import java.util.List;

import com.tcl.emp.dto.AdresssDto;
import com.tcl.emp.dto.EmployeeDto;
import com.tcl.emp.entity.Employee;
import com.tcl.emp.entity.EmployeeAddress;
import com.tcl.emp.exception.EmployeeException;
import com.tcl.emp.exception.MyExceptionHndler;
import com.tcl.emp.repo.AddressRepository;
import com.tcl.emp.repo.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public final class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private EmployeeRepository repository;

	private Employee newEmp;
	private EmployeeDto newDto;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto empDto) {

		Employee emp = mapper.map(empDto, Employee.class);
		try {
			newEmp = repository.save(emp);
			newDto = mapper.map(newEmp, EmployeeDto.class);

		} catch (Exception e) {
			throw new EmployeeException("employee already existed");

		}

		return newDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		List<EmployeeDto> empListDto = new ArrayList<>();

		repository.findAll(pageable).forEach(employee -> {

			EmployeeDto newEmployeeDto = mapper.map(employee, EmployeeDto.class);
			empListDto.add(newEmployeeDto);
		});

		return empListDto;
	}

	@Override
	public void deleteEmployee(Long emp_id) {

		repository.deleteById(emp_id);

	}

	@Override
	public EmployeeDto updatEmployee(EmployeeDto empDto, Long id) {
		Employee emp = repository.findById(id)
				.orElseThrow(() -> new EmployeeException("you are entered id is not available"));
		if (id.equals(emp.getEmp_id())) {
			emp.setName(empDto.getName());
			emp.setAge(empDto.getAge());
			emp.setMobileNo(empDto.getMobileNo());
			emp.setEmail(empDto.getEmail());
			emp.setGender(empDto.getGender());
			emp.setSal(empDto.getSal());
		}

		Employee newemp = repository.save(emp);
		EmployeeDto newEmpDto = mapper.map(newemp, EmployeeDto.class);

		return newEmpDto;
	}

	public EmployeeDto getEmployeeById(Long emp_id) {

		Employee employee = repository.findById(emp_id).orElseThrow(() -> new EmployeeException("invalid id"));

		EmployeeDto newDto = mapper.map(employee, EmployeeDto.class);

		return newDto;
	}
	

}
