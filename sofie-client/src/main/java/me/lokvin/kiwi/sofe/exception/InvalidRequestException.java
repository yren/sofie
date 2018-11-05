package me.lokvin.kiwi.sofe.exception;

public class InvalidRequestException extends SofieBaseException {

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
