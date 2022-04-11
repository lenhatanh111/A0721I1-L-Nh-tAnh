package common;

public class Validate {
    public static boolean checkPhone(String sdt){
        String regex="^(090)\\d{7}|(091)\\d{7}$";
        return sdt.matches(regex);

    }
    public  static boolean checkIDCard(String id_card){
        String regex="^\\d{9}|\\d{12}$";
        return id_card.matches(regex);
    }
    public static boolean checkEmail(String email){
        String regex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(regex);
    }
}
