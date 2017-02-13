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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysResources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_resources", catalog = "smartcampus")
public class SysResources implements java.io.Serializable {

	// Fields

	private Integer resourceId;
	private SysModules sysModules;
	private String resourceType;
	private String resourceName;
	private String resourceDesc;
	private String resourcePath;
	private String priority;
	private Integer enable;
	private Integer issys;
	private Set<SysAuthoritiesResources> sysAuthoritiesResourceses = new HashSet<SysAuthoritiesResources>(
			0);

	// Constructors

	/** default constructor */
	public SysResources() {
	}

	/** minimal constructor */
	public SysResources(Integer resourceId) {
		this.resourceId = resourceId;
	}

	/** full constructor */
	public SysResources(Integer resourceId, SysModules sysModules,
			String resourceType, String resourceName, String resourceDesc,
			String resourcePath, String priority, Integer enable,
			Integer issys,
			Set<SysAuthoritiesResources> sysAuthoritiesResourceses) {
		this.resourceId = resourceId;
		this.sysModules = sysModules;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.resourceDesc = resourceDesc;
		this.resourcePath = resourcePath;
		this.priority = priority;
		this.enable = enable;
		this.issys = issys;
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "RESOURCE_ID", unique = true, nullable = false, length = 100)
	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULE_ID")
	public SysModules getSysModules() {
		return this.sysModules;
	}

	public void setSysModules(SysModules sysModules) {
		this.sysModules = sysModules;
	}

	@Column(name = "RESOURCE_TYPE", length = 100)
	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@Column(name = "RESOURCE_NAME", length = 100)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "RESOURCE_DESC", length = 200)
	public String getResourceDesc() {
		return this.resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	@Column(name = "RESOURCE_PATH", length = 200)
	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	@Column(name = "PRIORITY", length = 100)
	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysResources")
	public Set<SysAuthoritiesResources> getSysAuthoritiesResourceses() {
		return this.sysAuthoritiesResourceses;
	}

	public void setSysAuthoritiesResourceses(
			Set<SysAuthoritiesResources> sysAuthoritiesResourceses) {
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

}