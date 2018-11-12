package me.lokvin.kiwi.sofe.protocol;

import me.lokvin.kiwi.sofe.exception.SofieBaseException;
import org.junit.Assert;
import org.junit.Test;

public class ProtocolEncapsulateBaseTest {

    @Test
    public void testUrlEncodeParameters() {
        String[] params = {"mike abc", "tom", "jerry"};
        String[] results = ProtocolEncapsulateBase.urlEncodeParameters(params);
        String[] expect = {"mike+abc", "tom", "jerry"};
        Assert.assertArrayEquals("should be equal array", expect, results);
    }

    @Test
    public void testUrlDecodeParameters() {
        String[] params = {"tom+hanks"};
        String[] results = ProtocolEncapsulateBase.urlDecodeParameters(params);
        String[] expected = {"tom hanks"};
        Assert.assertArrayEquals("should be equal array", expected, results);
    }

    @Test
    public void testValidateAndExtractSeparator() {

        String body = "id message";
        String idTag = "id";
        try {
            char separator = ProtocolEncapsulateBase.extractSeparator(body, idTag, true);
            Assert.assertEquals("should be equal empty char", ' ', separator);
        } catch (SofieBaseException e) {
            e.printStackTrace();
        }
    }
}
