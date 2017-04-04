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
 * SysPart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_part", catalog = "smartcampus")
public class SysPart implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysCollege sysCollege;
	private String partId;
	private String partDescription;
	private Set<SysTeacher> sysTeachers = new HashSet<SysTeacher>(0);

	// Constructors

	/** default constructor */
	public SysPart() {
	}

	/** full constructor */
	public SysPart(SysCollege sysCollege, String partId,
			String partDescription, Set<SysTeacher> sysTeachers) {
		this.sysCollege = sysCollege;
		this.partId = partId;
		this.partDescription = partDescription;
		this.sysTeachers = sysTeachers;
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
	@JoinColumn(name = "college_id")
	public SysCollege getSysCollege() {
		return this.sysCollege;
	}

	public void setSysCollege(SysCollege sysCollege) {
		this.sysCollege = sysCollege;
	}

	@Column(name = "part_id", length = 50)
	public String getPartId() {
		return this.partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	@Column(name = "part_description", length = 100)
	public String getPartDescription() {
		return this.partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sysPart")
	public Set<SysTeacher> getSysTeachers() {
		return this.sysTeachers;
	}

	public void setSysTeachers(Set<SysTeacher> sysTeachers) {
		this.sysTeachers = sysTeachers;
	}

}