package pkb.dev.api.pts.domain;

import lombok.Data;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "participants")
@Data
public class ParticipantVo {
	
	@Id
	@GeneratedValue
	@Column(name = "participant_no")
	private long participantNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "reg_date")
	private Date regdate;
	
}
