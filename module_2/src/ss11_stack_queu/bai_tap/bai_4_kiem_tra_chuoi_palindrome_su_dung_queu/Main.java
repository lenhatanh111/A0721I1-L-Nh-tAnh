package ss11_stack_queu.bai_tap.bai_4_kiem_tra_chuoi_palindrome_su_dung_queu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Queue<String> stringQueue = new LinkedList<>();
        String string = "Able was I ere I saw Elba";
        String[] arrayString = string.split("");
        for (String word : arrayString) {
            stringQueue.add(word.toLowerCase());
            stringStack.push(word.toLowerCase());
        }
        boolean check = true;
        while (!stringStack.isEmpty()) {
            if (!stringQueue.remove().equals(stringStack.pop())) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println(string + " : Is the palindrome!");
        } else {
            System.out.println(string + " : Is not the palindrome!");
        }
    }
}
