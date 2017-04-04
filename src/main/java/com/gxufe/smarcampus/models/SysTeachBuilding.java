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
 * SysTeachBuilding entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_teach_building", catalog = "smartcampus")
public class SysTeachBuilding implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysCampus sysCampus;
	private String teachBuildingName;
	private Integer teachBuildingFloor;
	private Integer teachBuildingNumber;
	private String remark;
	private Integer teachBuildingType;
	private Set<SysTeachBuildingApplyRecord> sysTeachBuildingApplyRecords = new HashSet<SysTeachBuildingApplyRecord>(
			0);

	// Constructors

	/** default constructor */
	public SysTeachBuilding() {
	}

	/** full constructor */
	public SysTeachBuilding(SysCampus sysCampus,
			String teachBuildingName, Integer teachBuildingFloor,
			Integer teachBuildingNumber, String remark,
			Integer teachBuildingType,
			Set<SysTeachBuildingApplyRecord> sysTeachBuildingApplyRecords
			) {
		this.sysCampus = sysCampus;
		this.teachBuildingName = teachBuildingName;
		this.teachBuildingFloor = teachBuildingFloor;
		this.teachBuildingNumber = teachBuildingNumber;
		this.remark = remark;
		this.teachBuildingType = teachBuildingType;
		this.sysTeachBuildingApplyRecords = sysTeachBuildingApplyRecords;
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

	@Column(name = "teach_building_name", length = 50)
	public String getTeachBuildingName() {
		return this.teachBuildingName;
	}

	public void setTeachBuildingName(String teachBuildingName) {
		this.teachBuildingName = teachBuildingName;
	}

	@Column(name = "teach_building_floor")
	public Integer getTeachBuildingFloor() {
		return this.teachBuildingFloor;
	}

	public void setTeachBuildingFloor(Integer teachBuildingFloor) {
		this.teachBuildingFloor = teachBuildingFloor;
	}

	@Column(name = "teach_building_number")
	public Integer getTeachBuildingNumber() {
		return this.teachBuildingNumber;
	}

	public void setTeachBuildingNumber(Integer teachBuildingNumber) {
		this.teachBuildingNumber = teachBuildingNumber;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "teach_building_type")
	public Integer getTeachBuildingType() {
		return this.teachBuildingType;
	}

	public void setTeachBuildingType(Integer teachBuildingType) {
		this.teachBuildingType = teachBuildingType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sysTeachBuilding")
	public Set<SysTeachBuildingApplyRecord> getSysTeachBuildingApplyRecords() {
		return this.sysTeachBuildingApplyRecords;
	}

	public void setSysTeachBuildingApplyRecords(
			Set<SysTeachBuildingApplyRecord> sysTeachBuildingApplyRecords) {
		this.sysTeachBuildingApplyRecords = sysTeachBuildingApplyRecords;
	}


}