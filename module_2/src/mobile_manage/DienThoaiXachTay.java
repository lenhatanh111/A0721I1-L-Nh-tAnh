package mobile_manage;

public class DienThoaiXachTay extends DienThoai {
    private String country;
    private String status;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DienThoaiXachTay(int id,String name, double price,int nums,String product,String country, String status) {
        super(id,name,price,nums,product);
        this.country = country;
        this.status = status;
    }
}
