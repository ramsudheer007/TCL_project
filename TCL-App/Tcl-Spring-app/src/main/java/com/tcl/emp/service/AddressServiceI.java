package com.tcl.emp.service;

import com.tcl.emp.dto.AdresssDto;

public interface AddressServiceI {
	
	public AdresssDto saveAddress(AdresssDto adresssDto,Long emp_id);
	
	public AdresssDto updateAddress(AdresssDto adresssDto);



}

