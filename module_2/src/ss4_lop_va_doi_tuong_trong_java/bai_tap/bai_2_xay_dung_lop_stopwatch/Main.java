package ss4_lop_va_doi_tuong_trong_java.bai_tap.bai_2_xay_dung_lop_stopwatch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        System.out.println("thời gian bắt đầu (miliseconds): " + stopWatch.start());
        //thuật toán sắp xếp chọn (selection sort) cho 100,000 số.
        double[] array = new double[100000];
        int min;
        for (int i = 0; i < 100000; i++) {
            array[i] = Math.floor(Math.random() * 99);
        }
        System.out.println(Arrays.toString(array));
        for (int j = 0; j < 100000 - 1; j++) {
            min = j;
            for (int k = j + 1; k < 100000; k++) {
                if (array[k] < array[min]) {
                    min = k;
                }
                if (k == 100000 - 1) {
                    double temp = array[min];
                    array[min] = array[j];
                    array[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(array));
        System.out.println("thời gian kết thúc (miliseconds): " + stopWatch.stop());
        System.out.println("thời gian thực thi chương trình (miliseconds): " + stopWatch.getElapsedTime());
    }
}
