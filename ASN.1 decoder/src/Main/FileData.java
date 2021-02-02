package Main;

import java.io.*;

public class FileData {

    private String path_to_file;
    private String path_to_file_2;

    public FileData (String path_to_read, String path_to_write) {
        path_to_file = path_to_read;
        path_to_file_2 = path_to_write;
    }

    public String[] OpenAndRead() throws IOException {

        FileReader FReader = new FileReader(path_to_file);
        BufferedReader varRead = new BufferedReader(FReader);

        int num = numStrings();
        String[] lines = new String[num];

        int i;
        for (i = 0; i < num; i++) {
            lines[i] = varRead.readLine();
        }

        varRead.close();
        return lines;

    }

    public void OpenAndWrite(String data) throws IOException{

            try {
                File file = new File("D:/Test.txt");

                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(data + "\n");
                bw.close();

                System.out.println("Запись завершена");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    int numStrings() throws IOException {

        FileReader text = new FileReader(path_to_file);
        BufferedReader y = new BufferedReader(text);

        String one;
        int num = 0;

        while ((one = y.readLine()) != null) {
            num++;
        }
        y.close();

        return num;
    }

}
