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
 * SysCollege entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_college", catalog = "smartcampus")
public class SysCollege implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysCampus sysCampus;
	private Integer collegeName;
	private Integer collegeDescription;
	private Set<SysTeacher> sysTeachers = new HashSet<SysTeacher>(0);
	private Set<SysProfessional> sysProfessionals = new HashSet<SysProfessional>(
			0);
	private Set<SysPart> sysParts = new HashSet<SysPart>(0);

	// Constructors

	/** default constructor */
	public SysCollege() {
	}

	/** full constructor */
	public SysCollege( SysCampus sysCampus,
			
			Integer collegeName, Integer collegeDescription,
			Set<SysTeacher> sysTeachers, Set<SysProfessional> sysProfessionals,
			Set<SysPart> sysParts) {
		this.collegeName = collegeName;
		this.collegeDescription = collegeDescription;
		this.sysTeachers = sysTeachers;
		this.sysProfessionals = sysProfessionals;
		this.sysParts = sysParts;
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
	@JoinColumn(name = "campus_id")
	public SysCampus getSysCampus() {
		return this.sysCampus;
	}

	public void setSysCampus(SysCampus sysCampus) {
		this.sysCampus = sysCampus;
	}



	@Column(name = "college_name")
	public Integer getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(Integer collegeName) {
		this.collegeName = collegeName;
	}

	@Column(name = "college_description")
	public Integer getCollegeDescription() {
		return this.collegeDescription;
	}

	public void setCollegeDescription(Integer collegeDescription) {
		this.collegeDescription = collegeDescription;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sysCollege")
	public Set<SysTeacher> getSysTeachers() {
		return this.sysTeachers;
	}

	public void setSysTeachers(Set<SysTeacher> sysTeachers) {
		this.sysTeachers = sysTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sysCollege")
	public Set<SysProfessional> getSysProfessionals() {
		return this.sysProfessionals;
	}

	public void setSysProfessionals(Set<SysProfessional> sysProfessionals) {
		this.sysProfessionals = sysProfessionals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sysCollege")
	public Set<SysPart> getSysParts() {
		return this.sysParts;
	}

	public void setSysParts(Set<SysPart> sysParts) {
		this.sysParts = sysParts;
	}


}