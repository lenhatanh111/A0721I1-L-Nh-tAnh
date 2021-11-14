package ss19_string_and_regex.bai_tap.bai_1_validate_ten_cua_lop_hoc;

public class ValidateClass {
    public static void main(String[] args) {
        String classRegex = "^[CAP]+[0-9]{4}+[GHIKLM]$";
        String[] testClass = {"A0721I", " M0318G", "P0323A", "C0318G"};
        for (String classes : testClass) {
            boolean matches = classes.matches(classRegex);
            System.out.println(matches);
        }
    }
}
