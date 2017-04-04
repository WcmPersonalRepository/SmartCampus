package com.gxufe.smarcampus.models;

import java.sql.Timestamp;
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
 * SysTeachBuildingApplyRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_teach_building_apply_record", catalog = "smartcampus")
public class SysTeachBuildingApplyRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysTeachBuilding sysTeachBuilding;
	private Integer userId;
	private Timestamp applyTime;
	private Integer startLesson;
	private Integer endLesso;
	private Timestamp applyUseDate;
	private Integer isAgree;
	private String mobile;
	private String useReason;
	private Integer state;
	private String useNeedDescription;
	private Integer flag;
	private String remark;
	private Integer teachBuildingType;

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
	public SysTeachBuildingApplyRecord(SysTeachBuilding sysTeachBuilding,
			Integer userId, Timestamp applyTime, Integer startLesson,
			Integer endLesso, Timestamp applyUseDate, Integer isAgree,
			String mobile, String useReason, Integer state,
			String useNeedDescription, Integer flag, String remark,
			Integer teachBuildingType) {
		this.sysTeachBuilding = sysTeachBuilding;
		this.userId = userId;
		this.applyTime = applyTime;
		this.startLesson = startLesson;
		this.endLesso = endLesso;
		this.applyUseDate = applyUseDate;
		this.isAgree = isAgree;
		this.mobile = mobile;
		this.useReason = useReason;
		this.state = state;
		this.useNeedDescription = useNeedDescription;
		this.flag = flag;
		this.remark = remark;
		this.teachBuildingType = teachBuildingType;
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
	@JoinColumn(name = "teach_building_id")
	public SysTeachBuilding getSysTeachBuilding() {
		return this.sysTeachBuilding;
	}

	public void setSysTeachBuilding(SysTeachBuilding sysTeachBuilding) {
		this.sysTeachBuilding = sysTeachBuilding;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "apply_time", nullable = false, length = 19)
	public Timestamp getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	@Column(name = "start_lesson")
	public Integer getStartLesson() {
		return this.startLesson;
	}

	public void setStartLesson(Integer startLesson) {
		this.startLesson = startLesson;
	}

	@Column(name = "end_lesso")
	public Integer getEndLesso() {
		return this.endLesso;
	}

	public void setEndLesso(Integer endLesso) {
		this.endLesso = endLesso;
	}

	@Column(name = "apply_use_date", nullable = false, length = 19)
	public Timestamp getApplyUseDate() {
		return this.applyUseDate;
	}

	public void setApplyUseDate(Timestamp applyUseDate) {
		this.applyUseDate = applyUseDate;
	}

	@Column(name = "is_agree")
	public Integer getIsAgree() {
		return this.isAgree;
	}

	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "use_reason", length = 200)
	public String getUseReason() {
		return this.useReason;
	}

	public void setUseReason(String useReason) {
		this.useReason = useReason;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "use_need_description", length = 200)
	public String getUseNeedDescription() {
		return this.useNeedDescription;
	}

	public void setUseNeedDescription(String useNeedDescription) {
		this.useNeedDescription = useNeedDescription;
	}

	@Column(name = "flag")
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
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

}