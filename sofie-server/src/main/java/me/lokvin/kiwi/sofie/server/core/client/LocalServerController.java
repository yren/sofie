package me.lokvin.kiwi.sofie.server.core.client;

import me.lokvin.kiwi.sofie.server.core.SofieMain;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * a client for controlling a Sofie Sever
 */
public class LocalServerController {

    private static Logger logger = LoggerFactory.getLogger(LocalServerController.class);

    private static final Options OPTS_CONTROLLER = new Options();
    private static final OptionGroup COMMANDS = new OptionGroup();
    private static final Option CMD_START = new Option("start", false, "Start Sofie server");
    private static final Option CMD_HELP = new Option("help", false, "Get help");

    static {
        // top level args
        COMMANDS.addOption(CMD_START);
        COMMANDS.setRequired(true);
        OPTS_CONTROLLER.addOptionGroup(COMMANDS);

        CMD_HELP.setRequired(false);
        OPTS_CONTROLLER.addOption(CMD_HELP);

    }

    public static void main(String[] args) {

        int exitCode = 0;

        try {
            SofieMain main = new SofieMain();
            CommandLineParser parser = new DefaultParser();
            CommandLine controllerOpts = parser.parse(OPTS_CONTROLLER, args, true);
            boolean helpFlag = controllerOpts.hasOption(CMD_HELP.getOpt());
            logger.info("flag = {}", helpFlag);
        } catch (Throwable t) {
            logger.warn("error", t);
        }
    }
}
