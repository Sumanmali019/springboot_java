package sumanmali.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DupicateEmailException extends RuntimeException {
    public DupicateEmailException(String message) {
        super(message);
    }
}
 