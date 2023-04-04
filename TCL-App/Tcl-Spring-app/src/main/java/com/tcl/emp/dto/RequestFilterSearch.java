package com.tcl.emp.dto;

import java.util.List;

public class RequestFilterSearch {
	
	public List<ResponseDto> dtoList;
	
	public String globalOprator;

	public List<ResponseDto> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<ResponseDto> dtoList) {
		this.dtoList = dtoList;
	}

	public String getGlobalOprator() {
		return globalOprator;
	}

	public void setGlobalOprator(String globalOprator) {
		this.globalOprator = globalOprator;
	}
	
	
	

}
