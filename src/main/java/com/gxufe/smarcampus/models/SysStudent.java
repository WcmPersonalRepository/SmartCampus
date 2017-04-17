package com.gxufe.smarcampus.models;

import java.sql.Timestamp;
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
 * SysStudent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_student", catalog = "smartcampus")
public class SysStudent implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysClass sysClass;
	private String studentNumber;
	private String realName;
	private String sex;
	private String mobile;
	private Timestamp intoSchoolYear;
	private String reservedField1;
	private String reservedField2;
	private String reservedField3;
	private String reservedField4;
	private Set<SysUsers> sysUserses = new HashSet<SysUsers>(0);

	// Constructors

	/** default constructor */
	public SysStudent() {
	}

	/** minimal constructor */
	public SysStudent(Timestamp intoSchoolYear) {
		this.intoSchoolYear = intoSchoolYear;
	}

	/** full constructor */
	public SysStudent(SysClass sysClass, String studentNumber, String realName,
			String sex, Timestamp intoSchoolYear, String reservedField1,
			String reservedField2, String reservedField3,String mobile,
			String reservedField4, Set<SysUsers> sysUserses) {
		this.sysClass = sysClass;
		this.studentNumber = studentNumber;
		this.realName = realName;
		this.sex = sex;
		this.mobile = mobile;
		this.intoSchoolYear = intoSchoolYear;
		this.reservedField1 = reservedField1;
		this.reservedField2 = reservedField2;
		this.reservedField3 = reservedField3;
		this.reservedField4 = reservedField4;
		this.sysUserses = sysUserses;
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
	@JoinColumn(name = "class_id")
	public SysClass getSysClass() {
		return this.sysClass;
	}

	public void setSysClass(SysClass sysClass) {
		this.sysClass = sysClass;
	}

	@Column(name = "student_number", length = 20)
	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	@Column(name = "real_name", length = 10)
	public String getRealName() {
		return this.realName;
	}
	
	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	@Column(name = "into_school_year", nullable = false, length = 19)
	public Timestamp getIntoSchoolYear() {
		return this.intoSchoolYear;
	}

	public void setIntoSchoolYear(Timestamp intoSchoolYear) {
		this.intoSchoolYear = intoSchoolYear;
	}

	@Column(name = "reserved_field1", length = 200)
	public String getReservedField1() {
		return this.reservedField1;
	}

	public void setReservedField1(String reservedField1) {
		this.reservedField1 = reservedField1;
	}

	@Column(name = "reserved_field2", length = 200)
	public String getReservedField2() {
		return this.reservedField2;
	}

	public void setReservedField2(String reservedField2) {
		this.reservedField2 = reservedField2;
	}

	@Column(name = "reserved_field3", length = 200)
	public String getReservedField3() {
		return this.reservedField3;
	}

	public void setReservedField3(String reservedField3) {
		this.reservedField3 = reservedField3;
	}

	@Column(name = "reserved_field4", length = 65535)
	public String getReservedField4() {
		return this.reservedField4;
	}

	public void setReservedField4(String reservedField4) {
		this.reservedField4 = reservedField4;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysStudent")
	public Set<SysUsers> getSysUserses() {
		return this.sysUserses;
	}

	public void setSysUserses(Set<SysUsers> sysUserses) {
		this.sysUserses = sysUserses;
	}

}