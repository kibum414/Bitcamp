package kb.dev.api.participant.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
public class ParticipantDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private long participantNo;
    private String name;
    private String gender;
    private String phoneNumber;
    private String email;
    private String birthday;
    private Date regdate;

}
