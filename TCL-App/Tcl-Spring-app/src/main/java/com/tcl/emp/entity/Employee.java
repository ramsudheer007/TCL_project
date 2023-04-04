package com.tcl.emp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="emp_data")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emp_id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false)
	private char gender;
	@Column(nullable = false,unique = true)
	private String mobileNo;
	private String altMobileNo;
	private Double sal;
	@Column(nullable = false,unique = true)
	private String email;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<EmployeeAddress> address_list;
	public Employee(Long emp_id, String name, Integer age, char gender, String mobileNo, String altMobileNo,
			Double sal, String email, List<EmployeeAddress> address_list) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.altMobileNo = altMobileNo;
		this.sal = sal;
		this.email = email;
		this.address_list = address_list;
	}
	public Employee() {
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
	public List<EmployeeAddress> getAddress_list() {
		return address_list;
	}
	public void setAddress_list(List<EmployeeAddress> address_list) {
		this.address_list = address_list;
	}
	
	

}
