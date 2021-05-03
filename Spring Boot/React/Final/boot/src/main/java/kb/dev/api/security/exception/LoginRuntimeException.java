package kb.dev.api.security.exception;

import java.io.Serializable;

public class LoginRuntimeException extends RuntimeException implements Serializable {
    private static final long serialVersionID = 1L;

    public LoginRuntimeException() {
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }

    public LoginRuntimeException(String message) {
        super(message);
    }
}
