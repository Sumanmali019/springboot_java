package sumanmali.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourrceNotFoundException extends RuntimeException {
    public ResourrceNotFoundException(String message) {
        super(message);
    }
}
