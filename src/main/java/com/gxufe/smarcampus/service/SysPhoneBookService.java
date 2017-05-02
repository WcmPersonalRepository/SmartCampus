package com.gxufe.smarcampus.service;

import java.util.List;

import com.gxufe.smarcampus.models.SysPhoneBook;
import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;

public interface SysPhoneBookService extends BaseService<SysPhoneBook, Integer> {
	public SysPhoneBook loadSysPhoneBookById(Integer id);
	public List<SysPhoneBook> findPhoneBookByDepartmentHQL(String HQL,
			String department);
	
}
