package Tests;

import Main.Coder;
import Main.Decoder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class CoderTest {
    
    private Coder coder;
    private Coder coder1;
    private Coder coder2;
    private Coder coder3;
    private Coder coder4;
    private Coder coder5;
    private Coder expected;
    BigInteger value;
    

    @Before
    public void setUp() throws Exception {
        String min = "0", max = "2743062034396844341627968125593604635037196317966166035056000994228098690879836473582587849768181396806642362668936055872479091931372323951612051859122835149807249350355003132267795098895967012320756270631179897595796976964454084495146379250195728106130226298287754794921070036903071843030324651025760255",
                simple = "1231241242", negative = "-127", edge = "128", incmax = "2743062034396844341627968125593604635037196317966166035056000994228098690879836473582587849768181396806642362668936055872479091931372323951612051859122835149807249350355003132267795098895967012320756270631179897595796976964454084495146379250195728106130226298287754794921070036903071843030324651025760256";
        coder = new Coder(value = new BigInteger(simple));
        coder1 = new Coder(value = new BigInteger(min));
        coder2 = new Coder(value = new BigInteger(max));
        coder3 = new Coder(value = new BigInteger(negative));
        coder4 = new Coder(value = new BigInteger(edge));
        coder5 = new Coder(value = new BigInteger(incmax));
        
    }

    @Test
    public void Coder() {

        String actual = "1000010001001001011000110100000000011010";
        expected = coder;
        assertEquals(expected.binstr,actual);
    }

    @Test
    public void Coder_minValue_Input() {
        String actual = null;
        expected = coder1;
        assertEquals(expected.binstr,actual);
    }

    @Test
    public void Coder_maxValue_Input() {
        String actual = null;
        expected = coder2;
        assertNotEquals(expected.binstr,actual);
    }

    @Test
    public void Coder_minValueIsOctet() {
        String actual = "0";
        expected = coder1;
        assertNotEquals(expected.binstr,actual);
    }


    @Test
    public void Coder_negativeValue_Input() {
        String actual = null;
        expected = coder3;
        assertEquals(expected.binstr,actual);
    }

    @Test
    public void Coder_edgeValue_Input() {
        String actual = "1000000110000000";
        expected = coder4;
        assertEquals(expected.binstr,actual);
    }

    @Test
    public void Coder_incMaxValue_Input() {
        String actual = null;
        expected = coder5;
        assertEquals(expected.binstr,actual);
    }

    
    
}