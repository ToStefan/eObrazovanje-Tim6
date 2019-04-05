package eobrazovanje.tim6.app.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import eobrazovanje.tim6.app.entity.User;

public class UserPrincipal implements UserDetails {
	
	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private boolean deleted = false;
	
	private Integer version;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserPrincipal() {
    	
    }
	
	

	public UserPrincipal(Long id, String username, String password, boolean deleted, Integer version,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deleted = deleted;
		this.version = version;
		this.authorities = authorities;
	}
	
	public static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
				new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList()); 
		
		return new UserPrincipal(
					user.getId(),
					user.getUsername(),
					user.getPassword(),
					user.getDeleted(),
					user.getVersion(),
					authorities
				);
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	

	public Long getId() {
		return id;
	}



	public boolean isDeleted() {
		return deleted;
	}



	public Integer getVersion() {
		return version;
	}



	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
