package com.tcl.emp.dto;

public class ResponseDto {
	
	
	private String columnName;
	private String value;
	
	private String localOprator;
	
	private String joinTable;
	
	
	
	public String getJoinTable() {
		return joinTable;
	}
	public void setJoinTable(String joinTable) {
		this.joinTable = joinTable;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLocalOprator() {
		return localOprator;
	}
	public void setLocalOprator(String localOprator) {
		this.localOprator = localOprator;
	}
	@Override
	public String toString() {
		return "ResponseDto [columnName=" + columnName + ", value=" + value + ", localOprator=" + localOprator + "]";
	}
	
	
	

}
