package by.teachmeskills.service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    protected final int status = HttpStatus.NOT_FOUND.value();

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getStatus() {
        return status;
    }
}
