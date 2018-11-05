package me.lokvin.kiwi.sofe.constants;

public interface SofieConstants {

    char PROTOCOL_SEPARATOR = ' ';
    String CURRENT_VERSION = "1.0";
    String ENCODING = "UTF-8";

    interface CriticalDefaults {
        // 5 seconds timeout
        int SHUTDOWN_TIMEMOUT = 5000;
        boolean RESPONSE_URL_ENCODE = false;
        String RESONSE_COMMAND = "UNKNOWN";
    }

    interface ClientDefaults {
    }

    interface SofieAlerts {
        String DEFAULT = "DEFAULT";
        String STARTUP = "STARTUP";
        String REFRESH = "REFRESH";
        String REFRESH_FAILURE = "REFRESH_FAILURE";
        String CONFIG_PROBLEM = "CONFIG_PROBLEM";
        String SHUTDOWN = "SHUTDOWN";
        String KILLED = "KILLED";
        String COMMAND_TIMEOUT = "COMMAND_TIMEOUT";
        String SERVER_MAX_CONNECTION = "SERVER_MAX_CONNECTION";
        String JMS_RECOVER = "JMS_RECOVER";
    }

    interface AdminClient {
        boolean URL_ENCODE_PARAMS = true;
        boolean URL_ENCODE_RESULTS = true;
    }

    interface Handshake {
    }

    interface ResponseStatus {
        short ACCEPTED = 1;
        short SUCCESS = 2;
        short BAD_REQUEST = 10;
        short BAD_COMMAND_REQUEST = 11;
        short UNKNOWN_COMMAND = 12;
        short UNKNOWN_VERSION = 13;
        short EXECUTION_ERROR = 14;
        short QUEUING_ERROR = 15;
        short SERVER_CONFIG_ERROR = 16;
        short SERVER_TOO_BUSY = 17;
        short EXECUTION_TIMEOUT = 19;
        short SHUTDONW_IN_PROGRESS = 20;

        short CORRUPTION_GENERIC = 40;

        short NO_NEED_VERIFY = -2;
    }

    interface CoreCommands {
        String REPLY_OK = "OK";
        String REPLY_TRUE = "TRUE";
        String REPLY_FALSE = "FALSE";

        String COMMAND_PING = "PING";
        String COMMAND_HANDSHAKE = "HANDSHAKE";
        String COMMAND_BYE = "BYE";
        String COMMAND_ADMIN = "ADMIN";
        String COMMAND_QUERY_STATUS = "QUERY_STATUS";
        String COMMAND_GET_CONNECTIONS = "GET_CONNECTIONS";
        String COMMAND_IDNET = "IDENT";
        String COMMAND_KILL_CONNECTION = "KILL_CONNECTION";
        String COMMAND_LAST_REFRESH = "LAST_REFRESH";
        String COMMAND_GET_CACHE_DATA = "GET_CACHE_DATA";
        String COMMAND_GET_SUPPORT_VERSIONS = "GET_SUPPORT_VERSIONS";
        String COMMAND_DB_DIAGNOSTICS = "DB_DIAGNOSTICS";
        String COMMAND_ALERT = "ALERT";
        String COMMAND_GET_HEALTH = "GET_HEALTH";
    }

    interface Ping {
        String PARAM_QUEUE = "QUEUE";
        String DEFAULT_REPLY = "PONG";
        String QUEUED_REPLY = "QUEUED";
    }
}
