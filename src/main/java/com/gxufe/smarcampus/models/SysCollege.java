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
	private String collegeName;
	private String collegeDescription;
	private Set<SysProfessional> sysProfessionals = new HashSet<SysProfessional>(
			0);

	// Constructors

	/** default constructor */
	public SysCollege() {
	}

	/** full constructor */
	public SysCollege(SysCampus sysCampus, String collegeName,
			String collegeDescription, Set<SysProfessional> sysProfessionals) {
		this.sysCampus = sysCampus;
		this.collegeName = collegeName;
		this.collegeDescription = collegeDescription;
		this.sysProfessionals = sysProfessionals;
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
	@JoinColumn(name = "campus_id")
	public SysCampus getSysCampus() {
		return this.sysCampus;
	}

	public void setSysCampus(SysCampus sysCampus) {
		this.sysCampus = sysCampus;
	}

	@Column(name = "college_name", length = 50)
	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Column(name = "college_description", length = 200)
	public String getCollegeDescription() {
		return this.collegeDescription;
	}

	public void setCollegeDescription(String collegeDescription) {
		this.collegeDescription = collegeDescription;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysCollege")
	public Set<SysProfessional> getSysProfessionals() {
		return this.sysProfessionals;
	}

	public void setSysProfessionals(Set<SysProfessional> sysProfessionals) {
		this.sysProfessionals = sysProfessionals;
	}

}