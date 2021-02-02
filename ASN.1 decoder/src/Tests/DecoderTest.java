package Tests;

import Main.Coder;
import Main.Decoder;
import Main.FileData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DecoderTest {

    private Decoder decoder;
    private Decoder decoder1;
    private Decoder decoder2;
    private Decoder decoder3;
    private Decoder decoder4;
    private Decoder decoder5;
    private Decoder decoder6;
    private Decoder decoder7;
    private Decoder decoder8;
    private Decoder decoder9;
    private Decoder decoder10;
    private Decoder decoder11;
    private Decoder decoder12;
    private Decoder expected;

    @Before
    public void setUp() throws Exception {
        BigInteger value = new BigInteger("2743062034396844341627968125593604635037196317966166035056000994228098690879836473582587849768181396806642362668936055872479091931372323951612051859122835149807249350355003132267795098895967012320756270631179897595796976964454084495146379250195728106130226298287754794921070036903071843030324651025760255");
        Coder maxValue = new Coder(value);
        decoder = new Decoder("1000010001001001111110111101110111110011");
        decoder2 = new Decoder("100001011001010100110001111001011110010011");
        decoder3 = new Decoder("String data");
        decoder4 = new Decoder("123441231");
        decoder5 = new Decoder("0");
        decoder6 = new Decoder("10000000");
        decoder7 = new Decoder("100000010000000000000001");
        decoder1 = new Decoder("00000001");
        decoder8 = new Decoder("1000000000000000");
        decoder9 = new Decoder("1000001000001010");
        decoder10 = new Decoder(maxValue.binstr);
        decoder11 = new Decoder("");
        decoder12 = new Decoder("        ");


    }

    @Test
    public void Decoder_binData_Input() {
        String actual ="1241243123";
        expected = decoder;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_isMultipleOf_8() {
        String actual =null;
        expected = decoder2;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_strData_Input() {
        String actual =null;
        expected = decoder3;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_intData_Input() {
        String actual =null;
        expected = decoder4;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_zeroData_Input() {
        String actual =null;
        expected = decoder5;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_zeroBinData_Input() {
        String actual =null;
        expected = decoder6;
        Assert.assertEquals(expected.result,actual);
    }


    @Test
    public void Decoder_minValue_Input() {
        String actual ="1";
        expected = decoder1;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_outOfBoundLength() {
        String actual =null;
        expected = decoder7;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_logZeroOctet() {
        String actual =null;
        expected = decoder8;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_insufficientLength() {
        String actual =null;
        expected = decoder9;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_maxValue_Input() {
        String actual ="2743062034396844341627968125593604635037196317966166035056000994228098690879836473582587849768181396806642362668936055872479091931372323951612051859122835149807249350355003132267795098895967012320756270631179897595796976964454084495146379250195728106130226298287754794921070036903071843030324651025760255";
        expected = decoder10;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_emptyString_Input() {
        String actual =null;
        expected = decoder11;
        Assert.assertEquals(expected.result,actual);
    }

    @Test
    public void Decoder_blankString_Input() {
        String actual =null;
        expected = decoder12;
        Assert.assertEquals(expected.result,actual);
    }

}