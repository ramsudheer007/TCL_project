package com.tcl.emp.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {

	private Long emp_id;
	@NotBlank(message = "name is required")
	private String name;
	@NotNull(message = "age is required")
	private Integer age;
	@NotNull(message = "gender is required")
	private char gender;
	@NotBlank(message = "moblie no is required")
	private String mobileNo;
	private String altMobileNo;
	private Double sal;
	@NotBlank(message = "email is required")
	private String email;

	private List<AdresssDto> addressList;

	public EmployeeDto(Long emp_id, @NotBlank(message = "name is required") String name,
			@NotNull(message = "age is required") Integer age, @NotNull(message = "gender is required") char gender,
			@NotBlank(message = "moblie no is required") String mobileNo, String altMobileNo, Double sal,
			@NotBlank(message = "email is required") String email) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.altMobileNo = altMobileNo;
		this.sal = sal;
		this.email = email;
	}

	public EmployeeDto(@NotBlank(message = "name is required") String name,
			@NotNull(message = "age is required") Integer age, @NotNull(message = "gender is required") char gender,
			@NotBlank(message = "moblie no is required") String mobileNo, String altMobileNo, Double sal,
			@NotBlank(message = "email is required") String email) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.altMobileNo = altMobileNo;
		this.sal = sal;
		this.email = email;
	}

	public EmployeeDto() {
		super();
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAltMobileNo() {
		return altMobileNo;
	}

	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AdresssDto> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AdresssDto> addressList) {
		this.addressList = addressList;
	}

}
