package com.gxufe.smarcampus.security.client;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gxufe.smarcampus.common.mapper.BeanMapper;
import com.gxufe.smarcampus.common.util.PasswordEncoderFactoryBean;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.models.SysUsers;
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
        	// List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
        	 //authsList.add(new GrantedAuthorityImpl("ROLE_SC"));
        	// Collection<GrantedAuthority> authoritise=new GrantedAuthority[authsList.size()];
        	// User userdetail = new User("wcm", "5e70f77dcc39f829a0c5bd872d506ebf131347bf6ede19cf63cce39df31a50bfea5999a5dde26e2c", true, true, true, true, authsList);
        	// User userdetail = null;
        	List<SysUsers> sysUsersList=sysUsersDao.find("from SysUsers as user where user.username=?",username);
        	SysUsers sysUsers=null;
        	if (sysUsersList.size()>0) {
        		sysUsers=sysUsersList.get(0);
			}
        	UserAuthDTO userAuthDto = null;
        	List<String> roleNames=new ArrayList<>();
        	Collection<SysRoles> authorities=new ArrayList<SysRoles>();
        	if (sysUsers!=null) {
        		//Set<SysUsersRoles> sysUsersRolesesSet=sysUsers.getSysRoles();
        		/*for (SysUsersRoles set:sysUsersRolesesSet) {
        			roleNames.add(set.getSysRoles().getRoleName());
        			authorities.add(set.getSysRoles());
				}*/
        		/*userAuthDto=new UserAuthDTO();
        		userAuthDto.setId(sysUsers.getUserId().toString());
        		userAuthDto.setPassword(sysUsers.getPassword());
        		userAuthDto.setRoles(roleNames);
        		userAuthDto.setUsername(username);
        		userAuthDto.setStatus(sysUsers.getStatus());*/
			}

            SpringSecurityUserAuth userAuthResult = new SpringSecurityUserAuth();
            //userAuthResult.setAuthorities(userAuthDto);
            if (sysUsers!=null) {
            	beanMapper.copy(sysUsers, userAuthResult);
			}

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
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-security.xml");  
//		BCryptPasswordEncoder bcryptEncoder=(BCryptPasswordEncoder) context.getBean("bcryptEncoder");
	        //System.out.println(generatePassword("000000"));  
		
	}

}
