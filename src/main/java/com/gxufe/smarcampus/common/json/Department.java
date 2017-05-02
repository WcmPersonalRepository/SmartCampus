package com.gxufe.smarcampus.common.json;

public class Department {
	private Integer id;
	private String department;
	private String remark;
	public Department() {
		super();
	}
	
	public Department(Integer id, String department, String remark) {
		super();
		this.id = id;
		this.department = department;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
