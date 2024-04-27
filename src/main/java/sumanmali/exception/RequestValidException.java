package sumanmali.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidException extends RuntimeException {
    public RequestValidException(String message) {
        super(message);
    }
}
