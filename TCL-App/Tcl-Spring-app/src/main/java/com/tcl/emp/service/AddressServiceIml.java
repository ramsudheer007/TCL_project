package com.tcl.emp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcl.emp.dto.AdresssDto;
import com.tcl.emp.entity.Employee;
import com.tcl.emp.entity.EmployeeAddress;
import com.tcl.emp.exception.EmployeeException;
import com.tcl.emp.repo.AddressRepository;
import com.tcl.emp.repo.EmployeeRepository;

@Service
public class AddressServiceIml implements AddressServiceI {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private AddressRepository addressRepository;

	private AdresssDto newDto;

	@Override
	public AdresssDto saveAddress(AdresssDto adresssDto, Long emp_id) {

		Employee emp = repository.findById(emp_id).orElseThrow(() -> new EmployeeException("invalid input id"));

		EmployeeAddress address = mapper.map(adresssDto, EmployeeAddress.class);
		List<EmployeeAddress> empAddressList=emp.getAddress_list();		
		empAddressList.add(address);
		emp.setAddress_list(empAddressList);

		if (emp.getEmp_id().equals(emp_id)) {

			try {
				EmployeeAddress newAdd = addressRepository.save(address);
				newDto = mapper.map(newAdd, AdresssDto.class);
			} catch (Exception e) {
				throw new EmployeeException("Allready existed");
			}

		}

		return newDto;
	}

	public AdresssDto updateAddressOfEmp(Long emp_id, Long add_id, AdresssDto dto) {
	Employee emp = repository.findById(emp_id).orElseThrow(() -> new EmployeeException("invalid input id"));
		
	EmployeeAddress adrAddress=	addressRepository.findById(add_id).orElseThrow(()->new EmployeeException("invald enter id"));
		
	if(add_id.equals(adrAddress.getAdd_id())) {
		
		adrAddress.setAdd_type(dto.getAdd_type());
		adrAddress.setAddress(dto.getAddress());
		adrAddress.setCity(dto.getCity());
		adrAddress.setCountry(dto.getCountry());
		adrAddress.setPincode(dto.getPincode());
		adrAddress.setState(dto.getState());
		
	}
	 
	    EmployeeAddress newAddress=  addressRepository.save(adrAddress);
	AdresssDto newDto= mapper.map(newAddress, AdresssDto.class);
		
		return newDto;
	}

	
	public AdresssDto updateAddress(AdresssDto adresssDto) {
		
		return adresssDto;
	}

}
