package kb.dev.api.participant.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "participants")
@Data
public class Participant {

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
