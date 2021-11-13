package ss17_binary_file_and_serialization.bai_tap.bai_1_quan_ly_san_pham_luu_ra_file_nhi_phan;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteObject {
    final static String PRODUCT_PATH = "src/ss17_binary_file_and_serialization/bai_tap/bai_1_quan_ly_san_pham_luu_ra_file_nhi_phan/product.csv";

    public static void writeObject(ArrayList<Product> products) {
        File file = new File(PRODUCT_PATH);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ArrayList<Product> list = new ArrayList<>();
        if (file.length() > 0) {
            list = readObject();
        }

        for (Product product : products) {
            list.add(product);
        }
        try {
            fileOutputStream = new FileOutputStream(file, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> readObject() {
        File file = new File(PRODUCT_PATH);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        ArrayList<Product> list = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
