package com.gxufe.smarcampus.common.json;

import com.gxufe.smarcampus.models.SysPart;

public class PhoneBooks {
	private Integer id;
	private String department;
	private String address;
	private Integer age;
	private String sex;
	private String realName;
	private String phone;
	private String remark;
	private Integer partId;
	private String partName;
	public Integer getId() {
		return id;
	}
	
	public PhoneBooks(Integer id, String department, String address,
			Integer age, String sex, String realName, String phone,
			String remark, Integer partId,String partName) {
		super();
		this.id = id;
		this.department = department;
		this.address = address;
		this.age = age;
		this.sex = sex;
		this.realName = realName;
		this.phone = phone;
		this.remark = remark;
		this.partId = partId;
		this.partName = partName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
	
}
