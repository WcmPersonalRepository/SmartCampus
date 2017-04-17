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
 * SysProfessional entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_professional", catalog = "smartcampus")
public class SysProfessional implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysCollege sysCollege;
	private String professionalName;
	private String professionalDescription;
	private String reservedField1;
	private String reservedField2;
	private String reservedField3;
	private String reservedField4;
	private String belongCourse;
	private String professionalCode;
	private String educationLevel;
	private Integer educationDuration;
	private Set<SysClass> sysClasses = new HashSet<SysClass>(0);

	// Constructors

	/** default constructor */
	public SysProfessional() {
	}

	/** full constructor */
	public SysProfessional(SysCollege sysCollege, String professionalName,
			String professionalDescription, String reservedField1,
			String reservedField2, String reservedField3,
			String reservedField4, String belongCourse,
			String professionalCode, String educationLevel,
			Integer educationDuration, Set<SysClass> sysClasses) {
		this.sysCollege = sysCollege;
		this.professionalName = professionalName;
		this.professionalDescription = professionalDescription;
		this.reservedField1 = reservedField1;
		this.reservedField2 = reservedField2;
		this.reservedField3 = reservedField3;
		this.reservedField4 = reservedField4;
		this.belongCourse = belongCourse;
		this.professionalCode = professionalCode;
		this.educationLevel = educationLevel;
		this.educationDuration = educationDuration;
		this.sysClasses = sysClasses;
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
	@JoinColumn(name = "college_id")
	public SysCollege getSysCollege() {
		return this.sysCollege;
	}

	public void setSysCollege(SysCollege sysCollege) {
		this.sysCollege = sysCollege;
	}

	@Column(name = "professional_name", length = 100)
	public String getProfessionalName() {
		return this.professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	@Column(name = "professional_description", length = 200)
	public String getProfessionalDescription() {
		return this.professionalDescription;
	}

	public void setProfessionalDescription(String professionalDescription) {
		this.professionalDescription = professionalDescription;
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

	@Column(name = "belong_course", length = 50)
	public String getBelongCourse() {
		return this.belongCourse;
	}

	public void setBelongCourse(String belongCourse) {
		this.belongCourse = belongCourse;
	}

	@Column(name = "professional_code", length = 10)
	public String getProfessionalCode() {
		return this.professionalCode;
	}

	public void setProfessionalCode(String professionalCode) {
		this.professionalCode = professionalCode;
	}

	@Column(name = "education_level", length = 10)
	public String getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	@Column(name = "education_duration")
	public Integer getEducationDuration() {
		return this.educationDuration;
	}

	public void setEducationDuration(Integer educationDuration) {
		this.educationDuration = educationDuration;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysProfessional")
	public Set<SysClass> getSysClasses() {
		return this.sysClasses;
	}

	public void setSysClasses(Set<SysClass> sysClasses) {
		this.sysClasses = sysClasses;
	}

}