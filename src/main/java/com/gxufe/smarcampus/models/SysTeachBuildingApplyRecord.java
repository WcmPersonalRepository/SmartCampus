package com.gxufe.smarcampus.models;

import java.sql.Timestamp;
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
 * SysTeachBuildingApplyRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_teach_building_apply_record", catalog = "smartcampus")
public class SysTeachBuildingApplyRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysUsers sysUsers;
	private SysTeachBuilding sysTeachBuilding;
	private Timestamp applyTime;
	private Timestamp applyUseDate;
	private Integer startLesson;
	private Integer endtLesson;
	private Integer flag;
	private Integer isAgree;
	private Integer state;
	private String mobile;
	private Integer teachBuildingType;
	private String useNeedDescription;
	private String useReason;
	private String remark;

	// Constructors

	/** default constructor */
	public SysTeachBuildingApplyRecord() {
	}

	/** minimal constructor */
	public SysTeachBuildingApplyRecord(Timestamp applyTime,
			Timestamp applyUseDate) {
		this.applyTime = applyTime;
		this.applyUseDate = applyUseDate;
	}

	/** full constructor */
	public SysTeachBuildingApplyRecord(SysUsers sysUsers,
			SysTeachBuilding sysTeachBuilding, Timestamp applyTime,
			Timestamp applyUseDate, Integer startLesson, Integer endtLesson,
			Integer flag, Integer isAgree, Integer state, String mobile,
			Integer teachBuildingType, String useNeedDescription,
			String useReason, String remark) {
		this.sysUsers = sysUsers;
		this.sysTeachBuilding = sysTeachBuilding;
		this.applyTime = applyTime;
		this.applyUseDate = applyUseDate;
		this.startLesson = startLesson;
		this.endtLesson = endtLesson;
		this.flag = flag;
		this.isAgree = isAgree;
		this.state = state;
		this.mobile = mobile;
		this.teachBuildingType = teachBuildingType;
		this.useNeedDescription = useNeedDescription;
		this.useReason = useReason;
		this.remark = remark;
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
	@JoinColumn(name = "user_id")
	public SysUsers getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(SysUsers sysUsers) {
		this.sysUsers = sysUsers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teach_building_id")
	public SysTeachBuilding getSysTeachBuilding() {
		return this.sysTeachBuilding;
	}

	public void setSysTeachBuilding(SysTeachBuilding sysTeachBuilding) {
		this.sysTeachBuilding = sysTeachBuilding;
	}

	@Column(name = "apply_time", nullable = false, length = 19)
	public Timestamp getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	@Column(name = "apply_use_date", nullable = false, length = 19)
	public Timestamp getApplyUseDate() {
		return this.applyUseDate;
	}

	public void setApplyUseDate(Timestamp applyUseDate) {
		this.applyUseDate = applyUseDate;
	}

	@Column(name = "start_lesson")
	public Integer getStartLesson() {
		return this.startLesson;
	}

	public void setStartLesson(Integer startLesson) {
		this.startLesson = startLesson;
	}

	@Column(name = "endt_lesson")
	public Integer getEndtLesson() {
		return this.endtLesson;
	}

	public void setEndtLesson(Integer endtLesson) {
		this.endtLesson = endtLesson;
	}

	@Column(name = "flag")
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Column(name = "is_agree")
	public Integer getIsAgree() {
		return this.isAgree;
	}

	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "teach_building_type")
	public Integer getTeachBuildingType() {
		return this.teachBuildingType;
	}

	public void setTeachBuildingType(Integer teachBuildingType) {
		this.teachBuildingType = teachBuildingType;
	}

	@Column(name = "use_need_description", length = 200)
	public String getUseNeedDescription() {
		return this.useNeedDescription;
	}

	public void setUseNeedDescription(String useNeedDescription) {
		this.useNeedDescription = useNeedDescription;
	}

	@Column(name = "use_reason", length = 200)
	public String getUseReason() {
		return this.useReason;
	}

	public void setUseReason(String useReason) {
		this.useReason = useReason;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}