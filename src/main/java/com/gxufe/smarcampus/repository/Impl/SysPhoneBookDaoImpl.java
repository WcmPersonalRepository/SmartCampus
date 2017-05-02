package com.gxufe.smarcampus.repository.Impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.models.SysCampus;
import com.gxufe.smarcampus.models.SysClass;
import com.gxufe.smarcampus.models.SysCollege;
import com.gxufe.smarcampus.models.SysPart;
import com.gxufe.smarcampus.models.SysPhoneBook;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.repository.SysPhoneBookDao;
import com.gxufe.smarcampus.repository.SysUsersDao;

@Repository
public class SysPhoneBookDaoImpl extends BaseDaoImpl<SysPhoneBook, Integer> implements SysPhoneBookDao {
	
	public SysPhoneBookDaoImpl() {
		this.entityClass = SysPhoneBook.class;
	}
	
}
