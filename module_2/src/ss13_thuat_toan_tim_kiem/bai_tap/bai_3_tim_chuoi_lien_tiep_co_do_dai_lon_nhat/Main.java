package ss13_thuat_toan_tim_kiem.bai_tap.bai_3_tim_chuoi_lien_tiep_co_do_dai_lon_nhat;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String string = "abcabcdgabmnsxy";
        LinkedList<Character> linkedListMax = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> characterLinkedList = new LinkedList<>();
            characterLinkedList.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (characterLinkedList.getLast() > string.charAt(j)) {
                    break;
                } else {
                    characterLinkedList.add(string.charAt(j));
                }
            }

            if (characterLinkedList.size() > linkedListMax.size()) {
                linkedListMax.clear();
                linkedListMax.addAll(characterLinkedList);
            }
        }
        for (Character ch : linkedListMax) {
            System.out.print(ch);
        }
    }
}
