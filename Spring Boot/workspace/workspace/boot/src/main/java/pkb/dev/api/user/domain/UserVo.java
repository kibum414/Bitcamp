package pkb.dev.api.user.domain;


import lombok.Data;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name="users")
@Data
public class UserVo {

	@Id
	@GeneratedValue
	@Column(name = "user_no")
	private long userNo;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "reg_date")
	private Date regdate;
	
}
