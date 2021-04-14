package pkb.dev.api.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDto {

    private long userId;
    private String username;
    private String password;
    private String name;
    private String birth;
    private String email;

}
