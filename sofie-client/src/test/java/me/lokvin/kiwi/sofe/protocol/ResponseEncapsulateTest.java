package me.lokvin.kiwi.sofe.protocol;

import me.lokvin.kiwi.sofe.exception.InvalidResponseException;
import me.lokvin.kiwi.sofe.exception.SofieBaseException;
import org.junit.Assert;
import org.junit.Test;

public class ResponseEncapsulateTest {

    @Test
    public void testCreate() {
        String[] params = {"param1", "param two"};
        ResponseEncapsulate resp = ResponseEncapsulate.create("1.0", "send", 200, params, ' ', true);
        Assert.assertEquals("Response version should be 1.0", "1.0", resp.getVersion());
        String[] encodeParams = {"param1", "param+two"};
        Assert.assertArrayEquals("params should be equal", encodeParams, resp.getResponseParameters());
    }

    @Test(expected = InvalidResponseException.class)
    public void testParseThrowInvalidResponseException() throws SofieBaseException {
        String body = ResponseEncapsulate.RESPONSE_KEYWORD + " 1.0";
        ResponseEncapsulate.parse(body);
    }

    @Test(expected = InvalidResponseException.class)
    public void testParseResponseCodeError() throws SofieBaseException {
        String body = ResponseEncapsulate.RESPONSE_KEYWORD + " 1.0 send 200k param1";
        ResponseEncapsulate.parse(body);
    }

    @Test
    public void testParse() throws SofieBaseException {
        String body = ResponseEncapsulate.RESPONSE_KEYWORD + " 1.0 send 200 param1";
        ResponseEncapsulate resp = ResponseEncapsulate.parse(body);
        Assert.assertEquals("Response version should be 1.0", "1.0", resp.getVersion());
        String[] params = {"param1"};
        Assert.assertArrayEquals("Params should be equal", params, resp.getResponseParameters());
    }
}
