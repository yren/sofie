package me.lokvin.kiwi.sofe.protocol;

import me.lokvin.kiwi.sofe.exception.InvalidResponseException;
import me.lokvin.kiwi.sofe.exception.SofieBaseException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class ResponseEncapsulate extends ProtocolEncapsulateBase {

    public static final String RESPONSE_KEYWORD = "SOFIERES";

    private String version;
    private String command;
    private int responseCode;
    private String[] responseParameters;
    private char protocolSeparator;

    public ResponseEncapsulate(char protocolSeparator) {
        this.protocolSeparator = protocolSeparator;
    }

    public static ResponseEncapsulate parse(String responseBody) throws SofieBaseException {
        char protocolSeparator = extractSeparator(responseBody, RESPONSE_KEYWORD, false);
        String[] parts = StringUtils.split(responseBody, protocolSeparator);
        if (parts == null || parts.length < 4) {
            throw new InvalidResponseException("Response was not properly format: " + responseBody);
        }

        int respCode = 0;
        try {
            respCode = Integer.parseInt(parts[3]);
        } catch (NumberFormatException nfe) {
            throw new InvalidResponseException("Response code not correct: " + parts[3]);
        }

        ResponseEncapsulate resp = new ResponseEncapsulate(protocolSeparator);
        resp.version = parts[1];
        resp.command = parts[2];
        resp.responseCode = respCode;
        resp.responseParameters = ArrayUtils.subarray(parts, 4, parts.length);
        return resp;
    }

    public static ResponseEncapsulate create(String version, String command, int responseCode, String[] responseParameters
        ,char protocolSeparator, boolean encodeParams) {
        ResponseEncapsulate resp = new ResponseEncapsulate(protocolSeparator);
        resp.version = version;
        resp.command = command;
        resp.responseCode = responseCode;
        String[] params = encodeParams ? urlEncodeParameters(responseParameters) : responseParameters;
        resp.responseParameters = params;
        return resp;
    }

    public String getVersion() {
        return version;
    }

    public String getCommand() {
        return command;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String[] getResponseParameters() {
        return responseParameters;
    }

    public char getProtocolSeparator() {
        return protocolSeparator;
    }

    @Override
    public String toString() {
        return "ResponseEncapsulate{" +
            "version='" + version + '\'' +
            ", command='" + command + '\'' +
            ", responseCode=" + responseCode +
            ", responseParameters=" + Arrays.toString(responseParameters) +
            ", protocolSeparator=" + protocolSeparator +
            '}';
    }
}
