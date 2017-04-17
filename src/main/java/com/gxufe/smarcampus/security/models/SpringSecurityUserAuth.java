package com.gxufe.smarcampus.security.models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gxufe.smarcampus.models.SysUsers;

public class SpringSecurityUserAuth extends SysUsers implements UserDetails {

	private Collection<? extends GrantedAuthority> authorities;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void getAuthorities(
            Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean isEnabled() {
       // return "1".equals(this.getStatus());
    	 return true;
    }

    public boolean isCredentialsNonExpired() {
    	/*Integer credentialsNonExpired=this.getCredentialsNonExpired();
    	if (!(null==credentialsNonExpired||credentialsNonExpired!=1)) {
			return true;
		}else{
			return false;
		}*/
    	return true;
    }

    public boolean isAccountNonLocked() {
    	/*Integer accountNonLocked=this.getAccountNonLocked();
    	if (!(null==accountNonLocked||accountNonLocked!=1)) {
			return true;
		}else{
			return false;
		}*/
    	return true;
    }

    public boolean isAccountNonExpired() {
    	/*Integer accountNonExpired=this.getAccountNonExpired();
    	if (!(null==accountNonExpired||accountNonExpired!=1)) {
			return true;
		}else{
			return false;
		}*/
    	return true;
    }
    
    

    // ~ ==================================================

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/*private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(getId());
        out.writeObject(getScopeId());
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        setId((String) in.readObject());
        setScopeId((String) in.readObject());
    }
*/
}
