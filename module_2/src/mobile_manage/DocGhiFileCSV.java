package mobile_manage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileCSV {
   private final String FILEPATH="src/mobile_manage/mobiles.csv";
    public List<String> readFile() {
            List<String> res= new ArrayList<>();

            try {
                File file= new File(FILEPATH);
                if(!file.exists())
                    file.createNewFile();

                BufferedReader bufferedReader= new BufferedReader(new FileReader(FILEPATH));
                String line;
                while ((line= bufferedReader.readLine())!= null){
                    res.add(line);
                }
                bufferedReader.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }

            return res;
        }

        void write(List<String> tList) {
            try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(FILEPATH))) {
                for (String t: tList){
                    bufferedWriter.write(t);
                    bufferedWriter.newLine();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
}
