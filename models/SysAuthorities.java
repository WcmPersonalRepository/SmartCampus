package com.gxufe.smarcampus.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
 * SysAuthorities entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_authorities", catalog = "smartcampus")
public class SysAuthorities implements java.io.Serializable {

	// Fields

	private Integer authorityId;
	private String authorityMark;
	private String authorityName;
	private String authorityDesc;
	private String message;
	private Integer enable;
	private Integer issys;
	private String moduleId;
	private Set<SysRolesAuthorities> sysRolesAuthoritieses = new HashSet<SysRolesAuthorities>(
			0);
	private Set<SysAuthoritiesResources> sysAuthoritiesResourceses = new HashSet<SysAuthoritiesResources>(
			0);

	// Constructors

	/** default constructor */
	public SysAuthorities() {
	}

	/** minimal constructor */
	public SysAuthorities(Integer authorityId, String authorityName) {
		this.authorityId = authorityId;
		this.authorityName = authorityName;
	}

	/** full constructor */
	public SysAuthorities(Integer authorityId, String authorityMark,
			String authorityName, String authorityDesc, String message,
			Integer enable, Integer issys, String moduleId,
			Set<SysRolesAuthorities> sysRolesAuthoritieses,
			Set<SysAuthoritiesResources> sysAuthoritiesResourceses) {
		this.authorityId = authorityId;
		this.authorityMark = authorityMark;
		this.authorityName = authorityName;
		this.authorityDesc = authorityDesc;
		this.message = message;
		this.enable = enable;
		this.issys = issys;
		this.moduleId = moduleId;
		this.sysRolesAuthoritieses = sysRolesAuthoritieses;
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "AUTHORITY_ID", unique = true, nullable = false, length = 100)
	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysAuthorities")
	public Set<SysRolesAuthorities> getSysRolesAuthoritieses() {
		return this.sysRolesAuthoritieses;
	}

	public void setSysRolesAuthoritieses(
			Set<SysRolesAuthorities> sysRolesAuthoritieses) {
		this.sysRolesAuthoritieses = sysRolesAuthoritieses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysAuthorities")
	public Set<SysAuthoritiesResources> getSysAuthoritiesResourceses() {
		return this.sysAuthoritiesResourceses;
	}

	public void setSysAuthoritiesResourceses(
			Set<SysAuthoritiesResources> sysAuthoritiesResourceses) {
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

}