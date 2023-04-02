package ua.com.gfalcon.finviz.exception;

public class FinvizApiException extends RuntimeException {

    public FinvizApiException() {
    }

    public FinvizApiException(String message) {
        super(message);
    }

    public FinvizApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public FinvizApiException(Throwable cause) {
        super(cause);
    }

    public FinvizApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
