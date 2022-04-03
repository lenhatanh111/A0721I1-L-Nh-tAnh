package model.bean;

public class Rent_type {
    int rent_type_id;
    String rent_type_name;

    public Rent_type() {
    }

    public Rent_type(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }

    public Rent_type(int rent_type_id, String rent_type_name) {
        this.rent_type_id = rent_type_id;
        this.rent_type_name = rent_type_name;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getRent_type_name() {
        return rent_type_name;
    }

    public void setRent_type_name(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }
}
