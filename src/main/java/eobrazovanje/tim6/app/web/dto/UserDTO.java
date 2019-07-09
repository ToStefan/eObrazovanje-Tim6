package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Long id;
	private String username;
	public Set<Role> roles = new HashSet<>();

}
