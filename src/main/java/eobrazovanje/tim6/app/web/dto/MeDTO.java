package eobrazovanje.tim6.app.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeDTO {
	
	private String userType;
	private Object userData;

}
