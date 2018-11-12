package me.lokvin.kiwi.sofe.protocol;

import me.lokvin.kiwi.sofe.exception.InvalidRequestException;
import me.lokvin.kiwi.sofe.exception.SofieBaseException;
import org.junit.Assert;
import org.junit.Test;

public class RequestEncapsulateTest {

    @Test
    public void testCreate() {
        String[] params = {"param1", "param two"};
        RequestEncapsulate req = RequestEncapsulate.create("1.0", "send", params, ' ', true);
        Assert.assertEquals("version should be 1.0", "1.0", req.getRequestVersion());
        Assert.assertEquals("command should be 'send'",  "send", req.getRequestCommand());
        Assert.assertEquals("separator should be empty char", ' ', req.getProtocolSeparator());
        String encodeParams[] = {"param1", "param+two"};
        Assert.assertArrayEquals("encode params array should be same", encodeParams, req.getCommandParameters());
    }

    @Test(expected = InvalidRequestException.class)
    public void testParseThrowSofieBaseException() throws SofieBaseException {
        String body = "1.0";
        RequestEncapsulate.parse(body);
    }

    @Test
    public void testParseThrowIllegalArgumentException() throws SofieBaseException {
        String body = RequestEncapsulate.REQUEST_KEYWORD + " 1.0 send param1 param2 param3";
        RequestEncapsulate req = RequestEncapsulate.parse(body);
        Assert.assertEquals("version should be 1.0", "1.0", req.getRequestVersion());
        String[] params = {"param1", "param2", "param3"};
        Assert.assertArrayEquals("params array should be equal", params, req.getCommandParameters());
    }
}
