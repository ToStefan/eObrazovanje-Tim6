
package eobrazovanje.tim6.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private RoleName name;
	
	public Role() {
		
	}
	
	public Role(RoleName name) {
		
		this.name = name;
	}
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public RoleName getName() {
		
		return name;
	}
	
	public void setName(RoleName name) {
		
		this.name = name;
	}
}
