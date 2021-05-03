package kb.dev.api.user.service;

import kb.dev.api.user.domain.UserDto;

public interface UserService {
    public long signup(UserDto user);
}
