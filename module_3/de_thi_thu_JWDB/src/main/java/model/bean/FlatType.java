package model.bean;

public class FlatType {
    private int flat_type_id;
    private String flat_type_name;

    public FlatType() {
    }

    public FlatType(int flat_type_id, String flat_type_name) {
        this.flat_type_id = flat_type_id;
        this.flat_type_name = flat_type_name;
    }

    public FlatType(String flat_type_name) {
        this.flat_type_name = flat_type_name;
    }

    public int getFlat_type_id() {
        return flat_type_id;
    }

    public void setFlat_type_id(int flat_type_id) {
        this.flat_type_id = flat_type_id;
    }

    public String getFlat_type_name() {
        return flat_type_name;
    }

    public void setFlat_type_name(String flat_type_name) {
        this.flat_type_name = flat_type_name;
    }
}
