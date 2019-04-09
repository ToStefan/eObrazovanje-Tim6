
package eobrazovanje.tim6.app.entity;

import java.util.Iterator;
import java.util.Set;

public class User {
	
	private Long id;
	private String username;
	private String password;
	private Boolean deleted = false;
	private Integer version;
	
	public Set<Role> role;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public String getUsername() {
		
		return username;
	}
	
	public void setUsername(String newUsername) {
		
		username = newUsername;
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String newPassword) {
		
		password = newPassword;
	}
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean newDeleted) {
		
		deleted = newDeleted;
	}
	
	public Integer getVersion() {
		
		return version;
	}
	
	public void setVersion(Integer newVersion) {
		
		version = newVersion;
	}
	
	public java.util.Set<Role> getRole() {
		
		if (role == null)
			role = new java.util.HashSet<Role>();
		return role;
	}
	
	public Iterator getIteratorRole() {
		
		if (role == null)
			role = new java.util.HashSet<Role>();
		return role.iterator();
	}
	
	public void setRole(java.util.Set<Role> newRole) {
		
		removeAllRole();
		for (Iterator iter = newRole.iterator(); iter.hasNext();)
			addRole((Role) iter.next());
	}
	
	public void addRole(Role newRole) {
		
		if (newRole == null)
			return;
		if (this.role == null)
			this.role = new java.util.HashSet<Role>();
		if (!this.role.contains(newRole))
			this.role.add(newRole);
	}
	
	public void removeRole(Role oldRole) {
		
		if (oldRole == null)
			return;
		if (this.role != null)
			if (this.role.contains(oldRole))
				this.role.remove(oldRole);
	}
	
	public void removeAllRole() {
		
		if (role != null)
			role.clear();
	}
	
}
