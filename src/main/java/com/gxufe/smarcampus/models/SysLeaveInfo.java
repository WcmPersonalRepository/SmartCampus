package com.gxufe.smarcampus.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysLeaveInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_leave_info", catalog = "smartcampus")
public class SysLeaveInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysUsers sysUsers;//申请人
	private String approverAdvice;//批假人意见
	private String approverDescription;//请假原因
	private Integer isFamilyAgree;//1家长同意请假  2不同意
	private Timestamp leaveEndDate;//请假结束节次
	private String leaveEndLesson;//请假结束节次
	private Timestamp leaveStartDate;//请假开始时间
	private String leaveStartLesson;//请假开始节次
	private String reservedField1;
	private String reservedField2;
	private String reservedField3;
	private String reservedField4;
	private Integer isNew;//1未处理 2已处理
	private Integer stateCode;//1单人请假 2多人请假
	private Integer statusCode;//0审批中 1已同意 2已拒绝
	private Timestamp applyDate;//请假日期
	private Timestamp teacherOptionDate;//批假日期
	private Integer isDelete;//0未删除 1已删除
	private Set<SysLeaveInfoRecord> sysLeaveInfoRecords = new HashSet<SysLeaveInfoRecord>(0);
	// Constructors

	/** default constructor */
	public SysLeaveInfo() {
	}

	/** minimal constructor */
	public SysLeaveInfo(Timestamp leaveEndDate, Timestamp leaveStartDate) {
		this.leaveEndDate = leaveEndDate;
		this.leaveStartDate = leaveStartDate;
	}

	/** full constructor */
	public SysLeaveInfo(SysUsers sysUsers,
			String approverAdvice, String approverDescription,
			Integer isFamilyAgree, Timestamp leaveEndDate,
			String leaveEndLesson, Timestamp leaveStartDate,
			String leaveStartLesson, String reservedField1,
			String reservedField2, String reservedField3,
			String reservedField4, Integer isNew, 
			Integer stateCode, Integer statusCode, Timestamp applyDate,
			Timestamp teacherOptionDate, Integer isDelete,Set<SysLeaveInfoRecord> sysLeaveInfoRecords) {
		this.sysUsers = sysUsers;
		this.approverAdvice = approverAdvice;
		this.approverDescription = approverDescription;
		this.isFamilyAgree = isFamilyAgree;
		this.leaveEndDate = leaveEndDate;
		this.leaveEndLesson = leaveEndLesson;
		this.leaveStartDate = leaveStartDate;
		this.leaveStartLesson = leaveStartLesson;
		this.reservedField1 = reservedField1;
		this.reservedField2 = reservedField2;
		this.reservedField3 = reservedField3;
		this.reservedField4 = reservedField4;
		this.isNew = isNew;
		this.stateCode = stateCode;
		this.statusCode = statusCode;
		this.applyDate = applyDate;
		this.teacherOptionDate = teacherOptionDate;
		this.isDelete = isDelete;
		this.sysLeaveInfoRecords = sysLeaveInfoRecords;
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

	@Column(name = "approver_advice", length = 10)
	public String getApproverAdvice() {
		return this.approverAdvice;
	}

	public void setApproverAdvice(String approverAdvice) {
		this.approverAdvice = approverAdvice;
	}

	@Column(name = "approver_description", length = 200)
	public String getApproverDescription() {
		return this.approverDescription;
	}

	public void setApproverDescription(String approverDescription) {
		this.approverDescription = approverDescription;
	}

	@Column(name = "is_family_agree")
	public Integer getIsFamilyAgree() {
		return this.isFamilyAgree;
	}

	public void setIsFamilyAgree(Integer isFamilyAgree) {
		this.isFamilyAgree = isFamilyAgree;
	}

	@Column(name = "leave_end_date", nullable = false, length = 19)
	public Timestamp getLeaveEndDate() {
		return this.leaveEndDate;
	}

	public void setLeaveEndDate(Timestamp leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	@Column(name = "leave_end_lesson", length = 10)
	public String getLeaveEndLesson() {
		return this.leaveEndLesson;
	}

	public void setLeaveEndLesson(String leaveEndLesson) {
		this.leaveEndLesson = leaveEndLesson;
	}

	@Column(name = "leave_start_date", nullable = false, length = 19)
	public Timestamp getLeaveStartDate() {
		return this.leaveStartDate;
	}

	public void setLeaveStartDate(Timestamp leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	@Column(name = "leave_start_lesson", length = 10)
	public String getLeaveStartLesson() {
		return this.leaveStartLesson;
	}

	public void setLeaveStartLesson(String leaveStartLesson) {
		this.leaveStartLesson = leaveStartLesson;
	}

	@Column(name = "reserved_field1", length = 200)
	public String getReservedField1() {
		return this.reservedField1;
	}

	public void setReservedField1(String reservedField1) {
		this.reservedField1 = reservedField1;
	}

	@Column(name = "reserved_field2", length = 100)
	public String getReservedField2() {
		return this.reservedField2;
	}

	public void setReservedField2(String reservedField2) {
		this.reservedField2 = reservedField2;
	}

	@Column(name = "reserved_field3", length = 200)
	public String getReservedField3() {
		return this.reservedField3;
	}

	public void setReservedField3(String reservedField3) {
		this.reservedField3 = reservedField3;
	}

	@Column(name = "reserved_field4", length = 100)
	public String getReservedField4() {
		return this.reservedField4;
	}

	public void setReservedField4(String reservedField4) {
		this.reservedField4 = reservedField4;
	}

	@Column(name = "is_new")
	public Integer getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	@Column(name = "state_code")
	public Integer getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	@Column(name = "status_code")
	public Integer getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Column(name = "apply_date", length = 19)
	public Timestamp getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Timestamp applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name = "teacher_option_date", length = 19)
	public Timestamp getTeacherOptionDate() {
		return this.teacherOptionDate;
	}

	public void setTeacherOptionDate(Timestamp teacherOptionDate) {
		this.teacherOptionDate = teacherOptionDate;
	}

	@Column(name = "is_delete")
	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysLeaveInfo")
	public Set<SysLeaveInfoRecord> getSysLeaveInfoRecords() {
		return sysLeaveInfoRecords;
	}

	public void setSysLeaveInfoRecords(Set<SysLeaveInfoRecord> sysLeaveInfoRecords) {
		sysLeaveInfoRecords = sysLeaveInfoRecords;
	}
	
	

}