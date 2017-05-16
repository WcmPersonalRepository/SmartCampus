package com.gxufe.smarcampus.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gxufe.smarcampus.common.PaginationSupport;
import com.gxufe.smarcampus.models.SysLeaveInfo;
import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.repository.Impl.SysUsersDaoImpl;
import com.gxufe.smarcampus.service.BaseService;
import com.gxufe.smarcampus.service.SysLeaveInfoService;
import com.gxufe.smarcampus.service.SysUsersService;

@Service
public class SysLeaveInfoServiceImpl extends BaseServicImpl<SysLeaveInfo, Integer> implements
SysLeaveInfoService {
}
