package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh.bai_5_tim_gia_tri_nho_nhat_trong_mang_su_dung_phuong_thuc;

public class Main {
    public static int minArray(int[]array){

        int index=0;
        for (int i=1;i<array.length;i++){
            if (array[index]<array[i]){
                index=i;
            }
        }
       return index;
    }

    public static void main(String[] args) {
        int []array={1,2,3,5,7,9,15,6,11};
        int index=minArray(array);
        System.out.println("phần tử lớn nhất trong mảng là: "+array[index]+" ở vị trí thứ "+(index+1));
    }
}
