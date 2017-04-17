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
 * SysCampus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_campus", catalog = "smartcampus")
public class SysCampus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String campusName;
	private String campusLocation;
	private String campusDescription;
	private String province;
	private String city;
	private Set<SysCollege> sysColleges = new HashSet<SysCollege>(0);
	private Set<SysTeachBuilding> sysTeachBuildings = new HashSet<SysTeachBuilding>(
			0);

	// Constructors

	/** default constructor */
	public SysCampus() {
	}

	/** full constructor */
	public SysCampus(String campusName, String campusLocation,
			String campusDescription, String province, String city,
			Set<SysCollege> sysColleges, Set<SysTeachBuilding> sysTeachBuildings) {
		this.campusName = campusName;
		this.campusLocation = campusLocation;
		this.campusDescription = campusDescription;
		this.province = province;
		this.city = city;
		this.sysColleges = sysColleges;
		this.sysTeachBuildings = sysTeachBuildings;
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

	@Column(name = "campus_name", length = 50)
	public String getCampusName() {
		return this.campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	@Column(name = "campus_location", length = 100)
	public String getCampusLocation() {
		return this.campusLocation;
	}

	public void setCampusLocation(String campusLocation) {
		this.campusLocation = campusLocation;
	}

	@Column(name = "campus_description", length = 65535)
	public String getCampusDescription() {
		return this.campusDescription;
	}

	public void setCampusDescription(String campusDescription) {
		this.campusDescription = campusDescription;
	}

	@Column(name = "province", length = 10)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 10)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysCampus")
	public Set<SysCollege> getSysColleges() {
		return this.sysColleges;
	}

	public void setSysColleges(Set<SysCollege> sysColleges) {
		this.sysColleges = sysColleges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysCampus")
	public Set<SysTeachBuilding> getSysTeachBuildings() {
		return this.sysTeachBuildings;
	}

	public void setSysTeachBuildings(Set<SysTeachBuilding> sysTeachBuildings) {
		this.sysTeachBuildings = sysTeachBuildings;
	}

}