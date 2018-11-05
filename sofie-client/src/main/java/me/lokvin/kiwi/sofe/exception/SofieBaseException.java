package me.lokvin.kiwi.sofe.exception;

public class SofieBaseException extends Exception {

    public SofieBaseException(String message) {
        super(message);
    }

    public SofieBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
