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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysOrganization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_organization", catalog = "smartcampus")
public class SysOrganization implements java.io.Serializable {

	// Fields

	private Integer id;
	private String organizationName;
	private String remark;
	private Set<SysPart> sysParts = new HashSet<SysPart>(0);

	// Constructors

	/** default constructor */
	public SysOrganization() {
	}

	/** full constructor */
	public SysOrganization(String organizationName, String remark,
			Set<SysPart> sysParts) {
		this.organizationName = organizationName;
		this.remark = remark;
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

	@Column(name = "organization_name", length = 50)
	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysOrganization")
	public Set<SysPart> getSysParts() {
		return this.sysParts;
	}

	public void setSysParts(Set<SysPart> sysParts) {
		this.sysParts = sysParts;
	}

}