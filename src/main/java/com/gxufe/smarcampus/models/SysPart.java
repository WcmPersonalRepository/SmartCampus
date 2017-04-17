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
	private SysOrganization sysOrganization;
	private String partName;
	private String partDescription;
	private String remark;
	private Set<SysTeacher> sysTeachers = new HashSet<SysTeacher>(0);

	// Constructors

	/** default constructor */
	public SysPart() {
	}

	/** full constructor */
	public SysPart(SysOrganization sysOrganization, String partName,
			String partDescription, String remark, Set<SysTeacher> sysTeachers) {
		this.sysOrganization = sysOrganization;
		this.partName = partName;
		this.partDescription = partDescription;
		this.remark = remark;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id")
	public SysOrganization getSysOrganization() {
		return this.sysOrganization;
	}

	public void setSysOrganization(SysOrganization sysOrganization) {
		this.sysOrganization = sysOrganization;
	}

	@Column(name = "part_name", length = 50)
	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	@Column(name = "part_description", length = 100)
	public String getPartDescription() {
		return this.partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysPart")
	public Set<SysTeacher> getSysTeachers() {
		return this.sysTeachers;
	}

	public void setSysTeachers(Set<SysTeacher> sysTeachers) {
		this.sysTeachers = sysTeachers;
	}

}