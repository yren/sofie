package me.lokvin.kiwi.sofe.protocol;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ProtocolEncapsulatorBaseTest {

    @Test
    public void testUrlEncodeParameters() {
        String[] params = {"mike abc", "tom", "jerry"};
        String[] results = ProtocolEncapsulatorBase.urlEncodeParameters(params);
        String[] expect = {"mike+abc", "tom", "jerry"};
        Assert.assertArrayEquals("should be equal", expect, results);
    }

    public void testUrlDecodeParameters() {
        Assert.fail("to be implement");
    }


    public void testValidateAndExtractSeparator() {
        Assert.fail("to be implement");
    }
}
