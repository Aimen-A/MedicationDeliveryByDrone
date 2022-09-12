package drone.tech.com.medicationDelivery.exception;

import drone.tech.com.medicationDelivery.domain.values.StatusCode;

public class ApplicationException extends Exception {

    private final int code;
    private final String message;

    public ApplicationException(String message, int code) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
