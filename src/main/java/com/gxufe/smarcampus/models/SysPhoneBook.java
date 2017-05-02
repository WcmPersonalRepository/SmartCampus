package com.gxufe.smarcampus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysPhoneBook entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_phone_book", catalog = "smartcampus")
public class SysPhoneBook implements java.io.Serializable {

	// Fields

	private Integer id;
	private String department;
	private String address;
	private Integer age;
	private String sex;
	private String realName;
	private String phone;
	private String remark;
	private SysPart sysPart;

	// Constructors

	/** default constructor */
	public SysPhoneBook() {
	}

	/** full constructor */
	public SysPhoneBook(SysPart sysPart, String department, String address,
			Integer age, String sex, String realName, String phone,
			String remark) {
		this.sysPart = sysPart;
		this.department = department;
		this.address = address;
		this.age = age;
		this.sex = sex;
		this.realName = realName;
		this.phone = phone;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "part_id")
	public SysPart getSysPart() {
		return this.sysPart;
	}

	public void setSysPart(SysPart sysPart) {
		this.sysPart = sysPart;
	}

	@Column(name = "department", length = 100)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "sex", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "real_name", length = 50)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}