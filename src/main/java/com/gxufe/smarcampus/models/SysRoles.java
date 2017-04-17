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
 * SysRoles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_roles", catalog = "smartcampus")
public class SysRoles implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private SysUsers sysUsers;
	private String roleName;
	private String roleDesc;
	private Integer enable;
	private Integer issys;
	private String moduleId;
	private Set<SysAuthorities> sysAuthoritieses = new HashSet<SysAuthorities>(
			0);

	// Constructors

	/** default constructor */
	public SysRoles() {
	}

	/** full constructor */
	public SysRoles(SysUsers sysUsers, String roleName, String roleDesc,
			Integer enable, Integer issys, String moduleId,
			Set<SysAuthorities> sysAuthoritieses) {
		this.sysUsers = sysUsers;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.enable = enable;
		this.issys = issys;
		this.moduleId = moduleId;
		this.sysAuthoritieses = sysAuthoritieses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public SysUsers getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(SysUsers sysUsers) {
		this.sysUsers = sysUsers;
	}

	@Column(name = "ROLE_NAME", length = 100)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "ROLE_DESC", length = 200)
	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Column(name = "ENABLE", precision = 8, scale = 0)
	public Integer getEnable() {
		return this.enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	@Column(name = "ISSYS", precision = 8, scale = 0)
	public Integer getIssys() {
		return this.issys;
	}

	public void setIssys(Integer issys) {
		this.issys = issys;
	}

	@Column(name = "MODULE_ID", length = 100)
	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysRoles")
	public Set<SysAuthorities> getSysAuthoritieses() {
		return this.sysAuthoritieses;
	}

	public void setSysAuthoritieses(Set<SysAuthorities> sysAuthoritieses) {
		this.sysAuthoritieses = sysAuthoritieses;
	}

}