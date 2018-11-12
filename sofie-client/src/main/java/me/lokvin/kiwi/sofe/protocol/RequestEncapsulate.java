package me.lokvin.kiwi.sofe.protocol;

import me.lokvin.kiwi.sofe.exception.InvalidRequestException;
import me.lokvin.kiwi.sofe.exception.SofieBaseException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class RequestEncapsulate extends ProtocolEncapsulateBase {

    public static final String REQUEST_KEYWORD = "SOFIEREQ";

    private String requestCommand;
    private String requestVersion;
    private String[] commandParameters;
    private char protocolSeparator;

    private RequestEncapsulate(char protocolSeparator) {
        this.protocolSeparator = protocolSeparator;
    }

    public static RequestEncapsulate parse(String requestBody) throws SofieBaseException {
        char protocolSeparator = extractSeparator(requestBody, REQUEST_KEYWORD, true);
        String[] parts = StringUtils.split(requestBody, protocolSeparator);
        if (parts == null || parts.length < 3) {
            throw new InvalidRequestException("request not properly format.");
        }

        RequestEncapsulate request = new RequestEncapsulate(protocolSeparator);
        request.requestVersion = parts[1];
        request.requestCommand = parts[2];
        request.commandParameters = ArrayUtils.subarray(parts, 3, parts.length);
        return request;
    }

    public static RequestEncapsulate create(String version, String command, String[] commandParameters,
                                            char protocolSeparator, boolean encodeParams) {
        RequestEncapsulate req = new RequestEncapsulate(protocolSeparator);
        req.setRequestVersion(version);
        req.setRequestCommand(command);
        if (commandParameters == null) {
            req.setCommandParameters(new String[0]);
        } else {
            String[] params = encodeParams ? urlEncodeParameters(commandParameters) : commandParameters;
            req.setCommandParameters(params);
        }
        return req;
    }

    public void setRequestCommand(String requestCommand) {
        this.requestCommand = requestCommand;
    }

    public void setRequestVersion(String requestVersion) {
        this.requestVersion = requestVersion;
    }

    public void setCommandParameters(String[] commandParameters) {
        this.commandParameters = commandParameters;
    }

    public String getRequestCommand() {
        return requestCommand;
    }

    public String getRequestVersion() {
        return requestVersion;
    }

    public String[] getCommandParameters() {
        return commandParameters;
    }

    public char getProtocolSeparator() {
        return protocolSeparator;
    }

    @Override
    public String toString() {
        return "RequestEncapsulate{" +
            "requestCommand='" + requestCommand + '\'' +
            ", requestVersion='" + requestVersion + '\'' +
            ", commandParameters=" + Arrays.toString(commandParameters) +
            ", protocolSeparator=" + protocolSeparator +
            '}';
    }
}
