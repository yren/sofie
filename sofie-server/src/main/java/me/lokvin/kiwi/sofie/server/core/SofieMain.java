package me.lokvin.kiwi.sofie.server.core;

import me.lokvin.kiwi.sofie.server.core.context.StartupContextImpl;
import me.lokvin.kiwi.sofie.server.exception.StartupException;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides methods for starting up Sofie Server.
 * perform following tasks:
 * - configure log
 * - load configuration
 * - start Sofie system
 */
public class SofieMain {

    private Logger logger = LoggerFactory.getLogger(SofieMain.class);

    private StartupContextImpl startupCtx = null;

    public void initializeStartupContext(String[] args) throws StartupException {
        if (ArrayUtils.getLength(args) < 1) {
            logger.error("Missing application name from command line.");
            throw new StartupException(10);
        }

        try {
            logger.info("Create startup context with application name: {}", args[0]);
            startupCtx = new StartupContextImpl(args[0]);
        } catch (Throwable t) {
            logger.error("Unable setup startup context.", t);
            throw new StartupException(11);
        }
    }


}
