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
 * SysLeaveInfoRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_leave_info_record", catalog = "smartcampus")
public class SysLeaveInfoRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysUsers sysUsers;
	private SysLeaveInfo sysLeaveInfo;

	// Constructors

	/** default constructor */
	public SysLeaveInfoRecord() {
	}

	/** full constructor */
	public SysLeaveInfoRecord(SysUsers sysUsers, SysLeaveInfo sysLeaveInfo) {
		this.sysUsers = sysUsers;
		this.sysLeaveInfo = sysLeaveInfo;
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
	@JoinColumn(name = "leave_info_id")
	public SysLeaveInfo getSysLeaveInfo() {
		return this.sysLeaveInfo;
	}

	public void setSysLeaveInfo(SysLeaveInfo sysLeaveInfo) {
		this.sysLeaveInfo = sysLeaveInfo;
	}

}