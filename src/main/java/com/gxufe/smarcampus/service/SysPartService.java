package com.gxufe.smarcampus.service;

import com.gxufe.smarcampus.models.SysPart;
import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;

public interface SysPartService extends BaseService<SysPart, Integer> {
	public SysPart loadSysPartById(Integer id);
}
