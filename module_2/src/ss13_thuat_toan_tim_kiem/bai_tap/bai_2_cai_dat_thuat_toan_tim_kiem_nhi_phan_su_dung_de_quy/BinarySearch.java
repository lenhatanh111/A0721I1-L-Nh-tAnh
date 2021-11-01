package ss13_thuat_toan_tim_kiem.bai_tap.bai_2_cai_dat_thuat_toan_tim_kiem_nhi_phan_su_dung_de_quy;

public class BinarySearch {
    static int[] array = {1, 3, 4, 5, 7, 9, 12, 24, 32, 54, 67, 89, 93};
    public static int binarySearch(int[] array, int key,int first,int last) {

        while (first <= last) {
            int middle = (first + last) / 2;
            if (array[middle] == key) {

                return middle;
            } else if (array[middle] < key) {

                return binarySearch(array, key,middle+1,last);

            } else {

                return binarySearch(array, key,first,middle-1);
            }
        }
        return -1;


    }



    public static void main(String[] args) {
        System.out.println(binarySearch(array, 0,0,array.length-1));
        System.out.println(binarySearch(array, 93,0,array.length-1));

    }
}
