package by.teachmeskills.exception;

public class InputFormatException extends RuntimeException {

    public InputFormatException() {
        super();
    }

    public InputFormatException(String message) {
        super(message);
    }

    public InputFormatException(String message, Throwable cause) {
        super(message, cause);
    }

}
