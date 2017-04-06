package com.gxufe.smarcampus.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_teacher", catalog = "smartcampus")
public class SysTeacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysPart sysPart;
	private SysUsers sysUsers;
	private SysCollege sysCollege;
	private String workNumber;
	private String realName;
	private String sex;
	private String reservedField1;
	private String reservedField2;
	private String reservedField3;
	private String reservedField4;

	// Constructors

	/** default constructor */
	public SysTeacher() {
	}

	/** full constructor */
	public SysTeacher(SysPart sysPart, SysUsers sysUsers,
			SysCollege sysCollege, String workNumber, String sex,String realName,
			String reservedField1, String reservedField2,
			String reservedField3, String reservedField4 ) {
		this.sysPart = sysPart;
		this.sysUsers = sysUsers;
		this.sysCollege = sysCollege;
		this.workNumber = workNumber;
		this.sex = sex;
		this.realName = realName;
		this.reservedField1 = reservedField1;
		this.reservedField2 = reservedField2;
		this.reservedField3 = reservedField3;
		this.reservedField4 = reservedField4;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	public SysPart getSysPart() {
		return this.sysPart;
	}

	public void setSysPart(SysPart sysPart) {
		this.sysPart = sysPart;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public SysUsers getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(SysUsers sysUsers) {
		this.sysUsers = sysUsers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "college_id")
	public SysCollege getSysCollege() {
		return this.sysCollege;
	}

	public void setSysCollege(SysCollege sysCollege) {
		this.sysCollege = sysCollege;
	}

	@Column(name = "work_number", length = 20)
	public String getWorkNumber() {
		return this.workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}
	
	@Column(name = "real_name", length = 20)
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "sex", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "reserved_field1", length = 200)
	public String getReservedField1() {
		return this.reservedField1;
	}

	public void setReservedField1(String reservedField1) {
		this.reservedField1 = reservedField1;
	}

	@Column(name = "reserved_field2", length = 100)
	public String getReservedField2() {
		return this.reservedField2;
	}

	public void setReservedField2(String reservedField2) {
		this.reservedField2 = reservedField2;
	}

	@Column(name = "reserved_field3", length = 100)
	public String getReservedField3() {
		return this.reservedField3;
	}

	public void setReservedField3(String reservedField3) {
		this.reservedField3 = reservedField3;
	}

	@Column(name = "reserved_field4", length = 100)
	public String getReservedField4() {
		return this.reservedField4;
	}

	public void setReservedField4(String reservedField4) {
		this.reservedField4 = reservedField4;
	}


}