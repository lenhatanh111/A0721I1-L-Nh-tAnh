package ss16_io_text_file.bai_tap.bai_2_doc_file_csv;

import java.io.*;

public  class ReadFileCSV {
    static final String PATH ="src/ss16_io_text_file/bai_tap/bai_2_doc_file_csv/country.csv";
    private static void readFileCSV(String path) throws IOException {
        File file=new File(path);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String line;
        while ((line=bufferedReader.readLine())!=null){
            String[] country=line.split(",");
            System.out.println(country[0]+" code: "+country[1]+" name: "+country[2]);
        }

    }

    public static void main(String[] args) {
        try {
            readFileCSV(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
