package Exceptions;

public class NotPositiveValueException extends RuntimeException {

    public NotPositiveValueException() {
    }

    public NotPositiveValueException(String message) {
        super(message);
    }

    public NotPositiveValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotPositiveValueException(Throwable cause) {
        super(cause);
    }

    public NotPositiveValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
