package me.lokvin.kiwi.sofe.client;

import me.lokvin.kiwi.sofe.exception.SofieApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseSofieClient {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String version;
    private final char protocolSeparator;
    private final boolean urlEncodeArgsEnabled;
    private final boolean urlDecodeResultsEnabled;
    private final Logger commandLogger;
    private boolean isInitialized;


    protected abstract String performSofieRequest(String commandWithArgs, Logger commandLogger) throws SofieApiException;

    protected abstract void internalClose();

    public BaseSofieClient(String version, char protocolSeparator,
                           boolean urlEncodeArgsEnabled, boolean urlDecodeResultsEnabled,
                           Logger commandLogger) {
        this.version = version;
        this.protocolSeparator = protocolSeparator;
        this.urlEncodeArgsEnabled = urlEncodeArgsEnabled;
        this.urlDecodeResultsEnabled = urlDecodeResultsEnabled;
        this.commandLogger = commandLogger;
        isInitialized = true;
    }

    public final void close() {
        if (isInitialized) {
            synchronized (this) {
                if (isInitialized) {
                    internalClose();
                    isInitialized = false;
                    logger.debug("Closed client: {}", this);
                }
            }
        }
    }

    public final String[] sendReceive(String commandToRun,
                                      String[] argsForCommand, boolean urlEncodeArgsEnabled,
                                      Short expectedResponseStatus, String[] expectedRequiredResponses,
                                      Integer minNumResults, Integer maxNumResults) throws SofieApiException {
        if (!isInitialized) {
            throw new SofieApiException("Client not initialized.");
        }
        throw new RuntimeException();
    }

}
