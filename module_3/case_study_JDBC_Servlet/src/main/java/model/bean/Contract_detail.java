package model.bean;

public class Contract_detail {
   int contract_detail_int ;
   int contract_id ;
   int attach_service_id ;
    int quantity ;

    public Contract_detail() {
    }

    public Contract_detail(int contract_id, int attach_service_id, int quantity) {
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public Contract_detail(int contract_detail_int, int contract_id, int attach_service_id, int quantity) {
        this.contract_detail_int = contract_detail_int;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public int getContract_detail_int() {
        return contract_detail_int;
    }

    public void setContract_detail_int(int contract_detail_int) {
        this.contract_detail_int = contract_detail_int;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(int attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
