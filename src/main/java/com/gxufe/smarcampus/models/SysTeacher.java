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
	private String workNumber;
	private String sex;
	private String reservedField1;
	private String reservedField2;
	private String reservedField3;
	private String reservedField4;
	private String realName;
	private String positionName;
	private String mobile;
	private Set<SysUsers> sysUserses = new HashSet<SysUsers>(0);
	private Set<SysLeaveInfo> sysLeaveInfos = new HashSet<SysLeaveInfo>(0);

	// Constructors

	/** default constructor */
	public SysTeacher() {
	}

	/** full constructor */
	public SysTeacher(SysPart sysPart, String workNumber, String sex,
			String reservedField1, String reservedField2,
			String reservedField3, String reservedField4, String realName,
			String positionName, String mobile, Set<SysUsers> sysUserses,
			Set<SysLeaveInfo> sysLeaveInfos) {
		this.sysPart = sysPart;
		this.workNumber = workNumber;
		this.sex = sex;
		this.reservedField1 = reservedField1;
		this.reservedField2 = reservedField2;
		this.reservedField3 = reservedField3;
		this.reservedField4 = reservedField4;
		this.realName = realName;
		this.positionName = positionName;
		this.mobile = mobile;
		this.sysUserses = sysUserses;
		this.sysLeaveInfos = sysLeaveInfos;
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

	@Column(name = "work_number", length = 20)
	public String getWorkNumber() {
		return this.workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
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

	@Column(name = "real_name", length = 50)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "position_name", length = 20)
	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysTeacher")
	public Set<SysUsers> getSysUserses() {
		return this.sysUserses;
	}

	public void setSysUserses(Set<SysUsers> sysUserses) {
		this.sysUserses = sysUserses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysTeacher")
	public Set<SysLeaveInfo> getSysLeaveInfos() {
		return this.sysLeaveInfos;
	}

	public void setSysLeaveInfos(Set<SysLeaveInfo> sysLeaveInfos) {
		this.sysLeaveInfos = sysLeaveInfos;
	}

}