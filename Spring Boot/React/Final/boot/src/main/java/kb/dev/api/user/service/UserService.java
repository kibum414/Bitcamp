package kb.dev.api.user.service;

import kb.dev.api.user.domain.UserDto;
import kb.dev.api.user.domain.UserVo;

public interface UserService {
    public String signup(UserVo user);
    public UserDto signin(UserVo user);
}
