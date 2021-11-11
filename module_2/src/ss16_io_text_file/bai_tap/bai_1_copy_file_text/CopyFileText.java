package ss16_io_text_file.bai_tap.bai_1_copy_file_text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class CopyFileText {
   static final String SOURCEFILE ="src/ss16_io_text_file/bai_tap/bai_1_copy_file_text/test.txt";
   static final String DESTINATIONFILE ="src/ss16_io_text_file/bai_tap/bai_1_copy_file_text/file_copy.txt";
   private static void copyFileJava7(String source,String des) throws IOException {
      File fileSource=new File(source);
      File fileDes=new File(des);

      Files.copy(fileSource.toPath(),fileDes.toPath(), StandardCopyOption.REPLACE_EXISTING);

   }
   private static void copyFile(String source,String des) throws IOException {
      FileInputStream fileInputStream=new FileInputStream(source);
      FileOutputStream fileOutputStream=new FileOutputStream(des);
      byte[] buffer=new byte[1024];
      fileInputStream.read(buffer);
      fileOutputStream.write(buffer);
      fileInputStream.close();
      fileOutputStream.close();

   }
   private static void writeNumbersCharacter(String path) throws IOException {
      File file=new File(path);


      BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
      String line;
      String temp="";
      while ((line=bufferedReader.readLine())!=null){
         temp+=line;
      }
      bufferedReader.close();
     int res=temp.replace(" ","").length();
      System.out.println(res);

   }

   public static void main(String[] args) {
      try {
         copyFile(SOURCEFILE,DESTINATIONFILE);
         writeNumbersCharacter(SOURCEFILE);
      }catch (IOException e){
         e.printStackTrace();
      }
   }
}
