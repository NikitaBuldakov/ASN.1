package Main;

import java.io.IOException;
import java.math.BigInteger;

//Реализация класса декодирования
public class Decoder {

    public String result;

    public Decoder(String binData) throws IOException{

        int Lenght;

        //Проверка корректности получаемых данных
        if(checkData(binData)) {this.result = null;}

        else {

            //Проверка на короткую форму
            if (binData.length() == 8 && binData.charAt(0) == '0') {

                Lenght = Integer.parseInt(binData, 2);
                this.result = String.valueOf(Lenght);

            //Проверка длинной формы, что получаемый блок кратен 8
            } else if(binData.length() > 8 && (binData.length()%8 == 0)) {

                String lengthBin = binData.substring(1, 8);
                Lenght = Integer.parseInt(lengthBin, 2);



                try {

                    //Получение информации о длине блока
                    String dataOfLengthBin = binData.substring(8, 8 + 8 * Lenght);
                    if((Lenght*8)==binData.substring(8).length()){
                        try {

                            BigInteger bigLength = new BigInteger(dataOfLengthBin, 2);
                            this.result = bigLength.toString();

                        }catch (NumberFormatException e){this.result = null;}
                    }else {this.result = null;}

                }catch (StringIndexOutOfBoundsException e){this.result = null;}

            } else {this.result = null;}

        }

    }

    private boolean checkData(String binData) throws NumberFormatException {

        try {
            BigInteger check = new BigInteger(binData, 2);
                return false;
        }catch (NumberFormatException e){
            return true;
        }


    }

}
