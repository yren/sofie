package me.lokvin.kiwi.sofe.exception;

public class InvalidResponseException extends SofieBaseException {
    private boolean responseTooSmall = false;

    public InvalidResponseException(String message) {
        super(message);
    }

    public InvalidResponseException(String message, boolean responseTooSmall) {
        super(message);
        this.responseTooSmall = responseTooSmall;
    }

    public InvalidResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public boolean isResponseTooSmall() {
        return responseTooSmall;
    }
}
