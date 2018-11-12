package me.lokvin.kiwi.sofe.protocol;

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
}
