package model.bean;

public class BenhAn {
    String ma_benh_an;
    String ma_benh_nhan;

    public BenhAn() {
    }

    public BenhAn(String ma_benh_an) {
        this.ma_benh_an = ma_benh_an;
    }

    public BenhAn(String ma_benh_an, String ma_benh_nhan) {
        this.ma_benh_an = ma_benh_an;
        this.ma_benh_nhan = ma_benh_nhan;
    }

    public String getMa_benh_an() {
        return ma_benh_an;
    }

    public void setMa_benh_an(String ma_benh_an) {
        this.ma_benh_an = ma_benh_an;
    }

    public String getMa_benh_nhan() {
        return ma_benh_nhan;
    }

    public void setMa_benh_nhan(String ma_benh_nhan) {
        this.ma_benh_nhan = ma_benh_nhan;
    }
}
