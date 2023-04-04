package com.tcl.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_data")
public class EmployeeAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long add_id;
	@Column(nullable = false)
	private String add_type;
	private String address;
	@Column(nullable = false)
	private String city;
	private String state;
	@Column(nullable = false)
	private String pincode;
	private String country;

	public EmployeeAddress(Long add_id, String add_type, String address, String city, String state, String pincode,
			String country) {
		super();
		this.add_id = add_id;
		this.add_type = add_type;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
	}

	public EmployeeAddress() {
		super();
	}

	public Long getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Long add_id) {
		this.add_id = add_id;
	}

	public String getAdd_type() {
		return add_type;
	}

	public void setAdd_type(String add_type) {
		this.add_type = add_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
