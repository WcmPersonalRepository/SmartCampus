package com.gxufe.smarcampus.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysLeaveInfoRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_leave_info_record", catalog = "smartcampus")
public class SysLeaveInfoRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp leaveStartDate;
	private Timestamp leaveEndDate;
	private Integer leaveStartLesson;
	private Integer leaveEndLesson;
	private Integer leaverId;
	private Integer approverId;
	private Integer isFamilyAgree;
	private String approverAgree;
	private String approverDescription;
	private String reservedField1;
	private String reservedField2;
	private String reservedField3;
	private String reservedField4;
	private Integer flag;
	private SysUsers sysUsers;

	// Constructors

	/** default constructor */
	public SysLeaveInfoRecord() {
	}

	/** minimal constructor */
	public SysLeaveInfoRecord(Timestamp leaveStartDate, Timestamp leaveEndDate) {
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
	}

	/** full constructor */
	public SysLeaveInfoRecord(Timestamp leaveStartDate, Timestamp leaveEndDate,
			Integer leaveStartLesson, Integer leaveEndLesson, Integer leaverId,
			Integer approverId, Integer isFamilyAgree, String approverAgree,
			String approverDescription, String reservedField1,
			String reservedField2, String reservedField3,
			String reservedField4, Integer flag, SysUsers sysUsers) {
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveStartLesson = leaveStartLesson;
		this.leaveEndLesson = leaveEndLesson;
		this.leaverId = leaverId;
		this.approverId = approverId;
		this.isFamilyAgree = isFamilyAgree;
		this.approverAgree = approverAgree;
		this.approverDescription = approverDescription;
		this.reservedField1 = reservedField1;
		this.reservedField2 = reservedField2;
		this.reservedField3 = reservedField3;
		this.reservedField4 = reservedField4;
		this.flag = flag;
		this.sysUsers = sysUsers;
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

	@Column(name = "leave_start_date", nullable = false, length = 19)
	public Timestamp getLeaveStartDate() {
		return this.leaveStartDate;
	}

	public void setLeaveStartDate(Timestamp leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	@Column(name = "leave_end_date", nullable = false, length = 19)
	public Timestamp getLeaveEndDate() {
		return this.leaveEndDate;
	}

	public void setLeaveEndDate(Timestamp leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	@Column(name = "leave_start_lesson")
	public Integer getLeaveStartLesson() {
		return this.leaveStartLesson;
	}

	public void setLeaveStartLesson(Integer leaveStartLesson) {
		this.leaveStartLesson = leaveStartLesson;
	}

	@Column(name = "leave_end_lesson")
	public Integer getLeaveEndLesson() {
		return this.leaveEndLesson;
	}

	public void setLeaveEndLesson(Integer leaveEndLesson) {
		this.leaveEndLesson = leaveEndLesson;
	}

	@Column(name = "leaver_id")
	public Integer getLeaverId() {
		return this.leaverId;
	}

	public void setLeaverId(Integer leaverId) {
		this.leaverId = leaverId;
	}

	@Column(name = "approver_id")
	public Integer getApproverId() {
		return this.approverId;
	}

	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}

	@Column(name = "is_family_agree")
	public Integer getIsFamilyAgree() {
		return this.isFamilyAgree;
	}

	public void setIsFamilyAgree(Integer isFamilyAgree) {
		this.isFamilyAgree = isFamilyAgree;
	}

	@Column(name = "approver_agree", length = 10)
	public String getApproverAgree() {
		return this.approverAgree;
	}

	public void setApproverAgree(String approverAgree) {
		this.approverAgree = approverAgree;
	}

	@Column(name = "approver_description", length = 200)
	public String getApproverDescription() {
		return this.approverDescription;
	}

	public void setApproverDescription(String approverDescription) {
		this.approverDescription = approverDescription;
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

	@Column(name = "flag")
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	public SysUsers getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(SysUsers sysUsers) {
		this.sysUsers = sysUsers;
	}

}