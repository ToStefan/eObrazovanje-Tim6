package eobrazovanje.tim6.app.web.dto;

import java.util.Set;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
	
	private String username;
	private String password;
	private RoleName role;

}
