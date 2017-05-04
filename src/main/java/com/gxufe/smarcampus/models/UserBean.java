package com.gxufe.smarcampus.models;

public class UserBean {
	private SysUsers sysUsers;
	private String userType;//1、教师  2、学生
	private SysStudent sysStudent;
	private SysClass sysClass;
	private SysProfessional sysProfessional;
	private SysCollege sysCollege;
	private SysCampus sysCampus;
	private SysTeacher sysTeacher;
	private SysPart sysPart;
	private SysOrganization sysOrganization;
	
	public SysStudent getSysStudent() {
		return sysStudent;
	}

	public void setSysStudent(SysStudent sysStudent) {
		this.sysStudent = sysStudent;
	}

	public SysPart getSysPart() {
		return sysPart;
	}

	public void setSysPart(SysPart sysPart) {
		this.sysPart = sysPart;
	}

	public SysOrganization getSysOrganization() {
		return sysOrganization;
	}

	public void setSysOrganization(SysOrganization sysOrganization) {
		this.sysOrganization = sysOrganization;
	}

	public SysTeacher getSysTeacher() {
		return sysTeacher;
	}

	public void setSysTeacher(SysTeacher sysTeacher) {
		this.sysTeacher = sysTeacher;
	}

	public SysClass getSysClass() {
		return sysClass;
	}

	public void setSysClass(SysClass sysClass) {
		this.sysClass = sysClass;
	}

	public SysProfessional getSysProfessional() {
		return sysProfessional;
	}

	public void setSysProfessional(SysProfessional sysProfessional) {
		this.sysProfessional = sysProfessional;
	}

	public SysCollege getSysCollege() {
		return sysCollege;
	}

	public void setSysCollege(SysCollege sysCollege) {
		this.sysCollege = sysCollege;
	}

	public SysCampus getSysCampus() {
		return sysCampus;
	}

	public void setSysCampus(SysCampus sysCampus) {
		this.sysCampus = sysCampus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public SysUsers getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(SysUsers sysUsers) {
		this.sysUsers = sysUsers;
	}
	
}
