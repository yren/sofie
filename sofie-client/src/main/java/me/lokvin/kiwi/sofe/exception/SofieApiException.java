package me.lokvin.kiwi.sofe.exception;

public class SofieApiException extends SofieBaseException {

    public SofieApiException(String message) {
        super(message);
    }

    public SofieApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
