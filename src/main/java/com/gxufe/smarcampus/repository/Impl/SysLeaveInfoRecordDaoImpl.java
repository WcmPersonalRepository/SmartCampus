package com.gxufe.smarcampus.repository.Impl;

import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.models.SysLeaveInfoRecord;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.repository.SysLeaveInfoRecordDao;
import com.gxufe.smarcampus.repository.SysRolesDao;
@Repository
public class SysLeaveInfoRecordDaoImpl extends BaseDaoImpl<SysLeaveInfoRecord, Integer> implements SysLeaveInfoRecordDao {
	public SysLeaveInfoRecordDaoImpl() {
		this.entityClass = SysLeaveInfoRecord.class;
	}
}
