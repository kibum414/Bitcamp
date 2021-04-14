package pkb.dev.api.user;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {

    private long userId;
    private String username;
    private String password;
    private String name;
    private String birth;
    private String email;

}
