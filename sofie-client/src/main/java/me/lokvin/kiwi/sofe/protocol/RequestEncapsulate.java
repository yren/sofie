package me.lokvin.kiwi.sofe.protocol;

import me.lokvin.kiwi.sofe.exception.InvalidRequestException;
import me.lokvin.kiwi.sofe.exception.SofieBaseException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class RequestEncapsulate extends ProtocolEncapsulateBase {

    public static final String REQUEST_KEYWORD = "SOFIE_REQUEST";

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
}
