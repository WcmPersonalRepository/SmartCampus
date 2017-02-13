package com.gxufe.smarcampus.service;

import com.gxufe.smarcampus.models.SysUsers;

public interface SysUsersService extends BaseService<SysUsers, Integer> {
	public void addUser(SysUsers sysUsers);
}
