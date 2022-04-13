package model.bean;

public class Customer {
   int customer_id ;
    String customer_name ;
   String customer_birthday ;
  Integer customer_gender ;
   String customer_id_card ;
   String customer_phone ;
   String customer_email ;
   String customer_address ;
   int customer_type_id ;
   String attach_service_name;
   String service_name;
   String customer_type_name;

    public Customer() {
    }

    public Customer(int customer_id, String customer_name, String customer_birthday, Integer customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, int customer_type_id, String attach_service_name, String service_name, String customer_type_name) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customer_type_id = customer_type_id;
        this.attach_service_name = attach_service_name;
        this.service_name = service_name;
        this.customer_type_name = customer_type_name;
    }

    public Customer(int customer_id, String customer_name, String customer_birthday, Integer customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, String customer_type_name) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customer_type_name = customer_type_name;
    }

    public Customer(String customer_name, String customer_birthday, Integer customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, int customer_type_id) {
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customer_type_id = customer_type_id;
    }

    public Customer(int customer_id, String customer_name, String customer_birthday, Integer customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, String attach_service_name, String service_name) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.attach_service_name = attach_service_name;
        this.service_name = service_name;
    }

    public Customer(int customer_id, String customer_name, String customer_birthday, Integer customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, int customer_type_id) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customer_type_id = customer_type_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(String customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public Integer getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(Integer customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_id_card() {
        return customer_id_card;
    }

    public void setCustomer_id_card(String customer_id_card) {
        this.customer_id_card = customer_id_card;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getCustomer_type_name() {
        return customer_type_name;
    }

    public void setCustomer_type_name(String customer_type_name) {
        this.customer_type_name = customer_type_name;
    }
}
