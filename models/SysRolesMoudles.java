package com.gxufe.smarcampus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysRolesMoudles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_roles_moudles", catalog = "smartcampus")
public class SysRolesMoudles implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysRoles sysRoles;
	private SysModules sysModules;

	// Constructors

	/** default constructor */
	public SysRolesMoudles() {
	}

	/** full constructor */
	public SysRolesMoudles(Integer id, SysRoles sysRoles, SysModules sysModules) {
		this.id = id;
		this.sysRoles = sysRoles;
		this.sysModules = sysModules;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false, length = 100)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	public SysRoles getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(SysRoles sysRoles) {
		this.sysRoles = sysRoles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULE_ID", nullable = false)
	public SysModules getSysModules() {
		return this.sysModules;
	}

	public void setSysModules(SysModules sysModules) {
		this.sysModules = sysModules;
	}

}