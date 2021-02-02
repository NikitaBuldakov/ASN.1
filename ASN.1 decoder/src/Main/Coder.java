package Main;

import java.math.BigInteger;

//Реализация класса кодирования
public class Coder {

    //Переменная для хранения результата
    public String binstr = "";



    public Coder(BigInteger value) {

        //Инициализация данных для проверки корректности получаемого значения для кодирования
        BigInteger Shortbase = new BigInteger("127");
        BigInteger maxValue = new BigInteger("2");
        maxValue = maxValue.pow(1008);
        int inc;

        //Смотрим находится ли значение для кодирования в допустимом диапозоне
        if((value.compareTo(BigInteger.ZERO) == 1)&&(value.compareTo(maxValue) < 0)) {

            //Проверка на короткую форму
            if (value.compareTo(Shortbase) < 1) {

                //Приведение двоичной формы числа к виду октета
                binstr = MakeOctet(binstr, value.toString(2).length());
                binstr = binstr + value.toString(2);

            } else {

                String data = "";

                //Устанавливаем старший бит в 1
                binstr = binstr + "1";

                data = value.toString(2);

                //Обработка исключительного случая при вводе числа от 128 до 255
                if(data.length()==8){
                    inc = 0;
                }else{
                    inc = 1;
                }

                //Количество октетов необходимых на кодирование длины
                BigInteger count = new BigInteger(((data.length() / 8) + inc) + "");

                //Обработка исключительного случая при вводе максимально доступного числа
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
