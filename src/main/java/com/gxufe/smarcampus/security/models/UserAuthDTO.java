package com.gxufe.smarcampus.security.models;

import java.util.List;
import java.util.Map;


public class UserAuthDTO {
	 private String id;
	    private String scopeId;
	    private String username;
	    private String password;
	    private String ref;
	    private String displayName;
	    private String status;
	    private List<String> roles;
	    private String depId;
	    private String depName;
	    private boolean enabled; 
		private boolean isSuperAdmin;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getScopeId() {
			return scopeId;
		}
		public void setScopeId(String scopeId) {
			this.scopeId = scopeId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRef() {
			return ref;
		}
		public void setRef(String ref) {
			this.ref = ref;
		}
		public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		public String getDepId() {
			return depId;
		}
		public void setDepId(String depId) {
			this.depId = depId;
		}
		public String getDepName() {
			return depName;
		}
		public void setDepName(String depName) {
			this.depName = depName;
		}
		public boolean isSuperAdmin() {
			return isSuperAdmin;
		}
		public void setSuperAdmin(boolean isSuperAdmin) {
			this.isSuperAdmin = isSuperAdmin;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public boolean isEnabled() {
			return enabled;
		}
		
		
		
}
