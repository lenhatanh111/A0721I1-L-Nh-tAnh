package ss11_stack_queu.bai_tap.bai_5_kiem_tra_dau_ngoac_trong_bieu_thuc_su_dung_stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> bStack = new Stack<>();
        String expressionString = "s*(a+1)*()s–b)*(s–c)";
        String[] expressionArray = expressionString.split("");
        boolean check = true;
        for (int i = 0; i < expressionArray.length; i++) {
            if (expressionArray[i].equals("(")) {
                bStack.push(expressionArray[i]);
            } else if (expressionArray[i].equals(")")) {
                if (bStack.isEmpty()) {
                    check = false;
                    break;
                } else if (expressionArray[i - 1].equals("(")) {   //kiểm tra xem giữa 2 ngoặc có biểu thức hay k
                    check = false;
                    break;
                }
                bStack.pop();
            }
        }
        if (!bStack.isEmpty()) {
            check = false;
        }
        System.out.println(check);
    }
}
