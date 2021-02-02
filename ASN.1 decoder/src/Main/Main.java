package Main;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg){

        boolean Check = false;
        String binData = "";
        int c = 0, i = 0;
        FileData FData = new FileData("D:/Test.txt", "D:/Test.bin");
        BigInteger value = new BigInteger("0");
        File file = new File("D:/Test.txt");
        Scanner scan = new Scanner(System.in);


        while (!Check){
            while (!Check) {

                try {
                    System.out.println("Выберете действие:\n1.Закодировать длину блока\n2.Декодировать длину блока\n");
                    c = scan.nextInt();
                    Check = true;

                } catch (NumberFormatException numberFormatException){
                    System.out.println("Неверный ввод данных!\n");
                    Check = false;
                }
            }
            switch (c){
                case 1:

                    Check = false;
                    while (!Check) {

                        try {

                            System.out.println("Введите размер блока\n");

                            String L = scan.nextLine();
                            value = new BigInteger(L);
                            Check = true;

                        } catch (NumberFormatException numberFormatException){

                            System.out.println("Неверный ввод данных!\n");
                            Check = false;
                        }
                    }
                    Coder cd = new Coder(value);
                    try {
                        FData.OpenAndWrite(cd.binstr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Check = false;
                    break;

                case 2:

                    try {
                        if (file.createNewFile()) {
                            System.out.println("File created: " + file.getName());
                        }
                        else {
                            System.out.println("File already exists.");
                        }


                        String[] aryStrings = FData.OpenAndRead();

                        Check = false;

                        while (!Check) {
                            try {

                                binData = aryStrings[i];
                                Decoder dc = new Decoder(binData);
                                i++;
                            }catch (ArrayIndexOutOfBoundsException ae){
                                System.out.println("Неверный ввод данных!\n");
                                Check = true;
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Check = false;
                    break;

                default:
                    break;

            }

        }

    }

}