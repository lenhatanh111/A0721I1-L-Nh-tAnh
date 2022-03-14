package ss14_thuat_toan_sap_xep.bai_tap.bai_1_minh_hoa_thuat_toan_sap_xep_chen;

public class InsertionSortByStep {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void insertionSortByStep(double[]list){
        for (int i=1;i<list.length;i++){
            double x=list[i];
            int pos=i;
            while (pos>0&&x<list[pos-1]){
                list[pos]=list[pos-1];
                pos--;

            }
            list[pos]=x;
            System.out.println("sort "+i);
            for (double element: list){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("list before insertionSort: ");
        for (double element: list){
            System.out.print(element+" ");
        }
        System.out.println();
        insertionSortByStep(list);
        System.out.println("list after insertionSort: ");
        for (double element: list){
            System.out.print(element+" ");
        }

    }
}
