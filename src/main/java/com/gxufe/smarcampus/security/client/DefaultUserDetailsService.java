package com.gxufe.smarcampus.security.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gxufe.smarcampus.common.mapper.BeanMapper;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.models.SysUsersRoles;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.security.models.SpringSecurityUserAuth;
import com.gxufe.smarcampus.security.models.UserAuthDTO;


public class DefaultUserDetailsService implements UserDetailsService {

	private static Logger logger = LoggerFactory
            .getLogger(DefaultUserDetailsService.class);
    //private UserAuthConnector userAuthConnector;
	@Autowired
	private SysUsersDao sysUsersDao;
    private String defaultPassword;
    private BeanMapper beanMapper = new BeanMapper();
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.debug("username : {}", username);
        try {
        	SysUsers sysUsers=(SysUsers) sysUsersDao.find("from SysUsers as user where user.username=?",username);
        	UserAuthDTO userAuthDto = null;
        	List<String> roleNames=new ArrayList<>();
        	Collection<SysRoles> authorities=new ArrayList<SysRoles>();
        	if (sysUsers!=null) {
        		Set<SysUsersRoles> sysUsersRolesesSet=sysUsers.getSysUsersRoleses();
        		for (SysUsersRoles set:sysUsersRolesesSet) {
        			roleNames.add(set.getSysRoles().getRoleName());
        			authorities.add(set.getSysRoles());
				}
        		userAuthDto.setId(sysUsers.getUserId().toString());
        		userAuthDto.setPassword(sysUsers.getPassword());
        		userAuthDto.setRoles(roleNames);
        		userAuthDto.setUsername(username);
			}

            SpringSecurityUserAuth userAuthResult = new SpringSecurityUserAuth();
            userAuthResult.setAuthorities(authorities);
            beanMapper.copy(userAuthDto, userAuthResult);

            if (defaultPassword != null) {
                userAuthResult.setPassword(defaultPassword);
            }

            return userAuthResult;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new UsernameNotFoundException(username, ex);
        }
	}


	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}
	
	

}
