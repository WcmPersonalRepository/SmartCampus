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
 * SysClass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_class", catalog = "smartcampus")
public class SysClass implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysProfessional sysProfessional;
	private SysTeacher sysTeacher;
	private String className;
	private String reservedField1;
	private String reservedField2;
	private String reservedField3;
	private String reservedField4;
	private Set<SysStudent> sysStudents = new HashSet<SysStudent>(0);

	// Constructors

	/** default constructor */
	public SysClass() {
	}

	/** full constructor */
	public SysClass(SysProfessional sysProfessional, String className,
			String reservedField1, String reservedField2,
			String reservedField3, String reservedField4,SysTeacher sysTeacher,
			Set<SysStudent> sysStudents) {
		this.sysProfessional = sysProfessional;
		this.className = className;
		this.reservedField1 = reservedField1;
		this.reservedField2 = reservedField2;
		this.reservedField3 = reservedField3;
		this.reservedField4 = reservedField4;
		this.sysStudents = sysStudents;
		this.sysTeacher = sysTeacher;;
		
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
	@JoinColumn(name = "professional_id")
	public SysProfessional getSysProfessional() {
		return this.sysProfessional;
	}

	public void setSysProfessional(SysProfessional sysProfessional) {
		this.sysProfessional = sysProfessional;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	public SysTeacher getSysTeacher() {
		return sysTeacher;
	}

	public void setSysTeacher(SysTeacher sysTeacher) {
		this.sysTeacher = sysTeacher;
	}

	@Column(name = "class_name", length = 10)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "reserved_field1", length = 100)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysClass")
	public Set<SysStudent> getSysStudents() {
		return this.sysStudents;
	}

	public void setSysStudents(Set<SysStudent> sysStudents) {
		this.sysStudents = sysStudents;
	}

}