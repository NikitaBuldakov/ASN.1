package Main;

import java.math.BigInteger;


public class Coder {

    public String binstr = "";



    public Coder(BigInteger value) {


        BigInteger Shortbase = new BigInteger("127");
        BigInteger maxValue = new BigInteger("2");
        maxValue = maxValue.pow(1008);
        int inc;


        if((value.compareTo(BigInteger.ZERO) == 1)&&(value.compareTo(maxValue) < 0)) {
            if (value.compareTo(Shortbase) < 1) {

                binstr = MakeOctet(binstr, value.toString(2).length());
                binstr = binstr + value.toString(2);
            } else {

                String data = "";
                binstr = binstr + "1";

                data = value.toString(2);

                if(data.length()==8){
                    inc = 0;
                }else{
                    inc =1;
                }

                BigInteger count = new BigInteger(((data.length() / 8) + inc) + "");

                if (count.compareTo(Shortbase) < 0) {
                    binstr = MakeOctet(binstr, count.toString(2).length() + 1);
                } else if (count.compareTo(Shortbase) == 0) {
                    binstr = MakeOctet(binstr = "", count.toString(2).length());
                } else {
                    binstr = null;
                }

                binstr = binstr + count.toString(2);

                if (inc == 1) {
                    binstr = MakeOctet(binstr, value.toString(2).length());
                }

                binstr = binstr + value.toString(2);
            }
        }else {
            binstr = null;
        }

    }


    private String MakeOctet(String data, int length){

        for(int i = 0; i < 8 - length%8; i++)
        {
            data = data + "0";
        }

        return data;
    }

}
