package by.teachmeskills.mvc.dao.exception;

/**
 * DAO exception
 */
public class DAOException extends RuntimeException {

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
