
package eobrazovanje.tim6.app.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", unique=false, nullable=false)
	private String password;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	public Set<Role> roles = new HashSet<>();
	
	public User() {

    }
	
	
	public User(Long id, String username, String password, Boolean deleted, Integer version, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deleted = deleted;
		this.version = version;
		this.roles = roles;
	}





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
	
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role newRole) {
		
		if (newRole == null)
			return;
		if (this.roles == null)
			this.roles = new java.util.HashSet<Role>();
		if (!this.roles.contains(newRole))
			this.roles.add(newRole);
	}
	
	public void removeRole(Role oldRole) {
		
		if (oldRole == null)
			return;
		if (this.roles != null)
			if (this.roles.contains(oldRole))
				this.roles.remove(oldRole);
	}
	
	public void removeAllRole() {
		
		if (roles != null)
			roles.clear();
	}
	
}
