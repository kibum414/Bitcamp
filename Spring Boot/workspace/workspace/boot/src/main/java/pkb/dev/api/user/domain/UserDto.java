package pkb.dev.api.user.domain;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long userNo;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String birthday;
	
	private String gender;
	
	private String email;
	
	private String phoneNumber;
	
	private Date regdate;
}
