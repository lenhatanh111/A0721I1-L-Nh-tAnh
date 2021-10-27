package ss11_stack_queu.bai_tap.bai_2_dem_so_lan_xuat_hien_cua_moi_tu_trong_mot_chuoi_su_dung_map;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        String string = "hello world";
        String[] arrayString = string.split("");
        for (String word : arrayString) {
            int count = 1;
            if (map.containsKey(word.charAt(0))) {
                count += map.get(word.charAt(0));
                map.replace(word.charAt(0), count);
            } else {
                map.put(word.charAt(0), count);
            }


        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }


}
