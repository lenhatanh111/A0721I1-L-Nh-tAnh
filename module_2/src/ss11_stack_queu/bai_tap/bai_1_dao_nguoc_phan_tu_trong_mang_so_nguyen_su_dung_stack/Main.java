package ss11_stack_queu.bai_tap.bai_1_dao_nguoc_phan_tu_trong_mang_so_nguyen_su_dung_stack;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> wordStack=new Stack<>();
        String string="lê nhật anh rất đẹp trai";
        String[] arrayString = string.split(" ");
        ArrayList<String> reverseWord=new ArrayList<>();
       for (String word:arrayString){
           wordStack.push(word);
       }
       while (!wordStack.isEmpty()){
           reverseWord.add(wordStack.pop());
       }
        System.out.println(String.join(" ",reverseWord));
    }
}
