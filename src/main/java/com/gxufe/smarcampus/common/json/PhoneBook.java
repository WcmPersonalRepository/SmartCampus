package com.gxufe.smarcampus.common.json;

import com.gxufe.smarcampus.models.SysPart;

public class PhoneBook {
	private Integer id;
	private String realName;
	private String phone;
	public PhoneBook() {
		super();
	}
	public PhoneBook(Integer id, String realName, String phone) {
		super();
		this.id = id;
		this.realName = realName;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
}
