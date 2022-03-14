package ss19_string_and_regex.bai_tap.bai_2_validate_so_dien_thoai;

public class ValidatePhoneNumbers {
    public static void main(String[] args) {
        String phoneNumbersRegex = "^[(]+[\\d]{2}+[)]+[-]+[(]+0+[\\d]{9}+[)]$";
        String[] testPhoneNumbers = {"(84)-(0978489648)","(a8)-(22222222)","(84)-(0352489513)","(723)-(0984555555)"};
        for (String pN : testPhoneNumbers) {
            boolean matches = pN.matches(phoneNumbersRegex);
            System.out.println(matches);
        }
    }
}
