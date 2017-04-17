package com.gxufe.smarcampus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysAuthorities entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_authorities", catalog = "smartcampus")
public class SysAuthorities implements java.io.Serializable {

	// Fields

	private Integer authorityId;
	private SysRoles sysRoles;
	private String authorityMark;
	private String authorityName;
	private String authorityDesc;
	private String message;
	private Integer enable;
	private Integer issys;
	private String moduleId;

	// Constructors

	/** default constructor */
	public SysAuthorities() {
	}

	/** minimal constructor */
	public SysAuthorities(String authorityName) {
		this.authorityName = authorityName;
	}

	/** full constructor */
	public SysAuthorities(SysRoles sysRoles, String authorityMark,
			String authorityName, String authorityDesc, String message,
			Integer enable, Integer issys, String moduleId) {
		this.sysRoles = sysRoles;
		this.authorityMark = authorityMark;
		this.authorityName = authorityName;
		this.authorityDesc = authorityDesc;
		this.message = message;
		this.enable = enable;
		this.issys = issys;
		this.moduleId = moduleId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AUTHORITY_ID", unique = true, nullable = false)
	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public SysRoles getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(SysRoles sysRoles) {
		this.sysRoles = sysRoles;
	}

	@Column(name = "AUTHORITY_MARK", length = 100)
	public String getAuthorityMark() {
		return this.authorityMark;
	}

	public void setAuthorityMark(String authorityMark) {
		this.authorityMark = authorityMark;
	}

	@Column(name = "AUTHORITY_NAME", nullable = false, length = 100)
	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Column(name = "AUTHORITY_DESC", length = 200)
	public String getAuthorityDesc() {
		return this.authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	@Column(name = "MESSAGE", length = 100)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
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

}