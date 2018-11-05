package me.lokvin.kiwi.sofe.protocol;

import me.lokvin.kiwi.sofe.constants.SofieConstants;
import me.lokvin.kiwi.sofe.exception.InvalidRequestException;
import me.lokvin.kiwi.sofe.exception.InvalidResponseException;
import me.lokvin.kiwi.sofe.exception.SofieBaseException;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class ProtocolEncapsulatorBase {

    public static char validateAndExtractSeparator(String body, String idTag, boolean isRequest)
        throws SofieBaseException {
        String exceptionMsg = null;
        boolean tooSmall = false;
        if (StringUtils.isEmpty(body) || body.length() < idTag.length() + 1) {
            exceptionMsg = " not long enough to include one separator!";
            tooSmall = true;
        } else if (!body.startsWith(idTag)) {
            exceptionMsg = " format invalid: does not begin with valid identifier: " + body;
        }

        if (exceptionMsg != null) {
            if (isRequest) {
                throw new InvalidRequestException("Request" + exceptionMsg);
            }
            throw new InvalidResponseException("Response" + exceptionMsg, tooSmall);
        }

        return body.charAt(idTag.length());
    }

    protected static String[] urlEncodeParameters(String[] commandParameters) {
        if (commandParameters == null) {
            return null;
        }
        String[] results = new String[commandParameters.length];

        for (int i=0; i< commandParameters.length; i++) {
            if (StringUtils.isBlank(commandParameters[i])) {
                throw new IllegalArgumentException("command parameter illegal: " + commandParameters[i]);
            }
            try {
                String encodeParam = URLEncoder.encode(commandParameters[i], SofieConstants.ENCODING_UTF8);
                results[i] = encodeParam;
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException("Error encoding parameter: " + commandParameters[i]);
            }
        }
        return results;
    }

    protected static String[] urlDecodeParameters(String[] commandParameters) {
        if (commandParameters == null) {
            return null;
        }
        String[] results = new String[commandParameters.length];
        for (int i = 0; i < commandParameters.length; i++) {
            try {
                results[i] = URLDecoder.decode(commandParameters[i], SofieConstants.ENCODING_UTF8);
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException("Error decoding parameter: " + commandParameters[i]);
            }
        }
        return results;
    }
 }
