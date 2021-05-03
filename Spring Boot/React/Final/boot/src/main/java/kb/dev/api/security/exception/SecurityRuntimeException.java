package kb.dev.api.security.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class SecurityRuntimeException extends RuntimeException {
    private static final long serialVersionID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

}
