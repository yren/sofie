package me.lokvin.kiwi.sofie.server.exception;

public class StartupException extends Exception {

    private int errorCode;

    public StartupException(int errorCode) {
        super("Error code (" + errorCode + ") - unable start sofie server, check logs for details");
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
