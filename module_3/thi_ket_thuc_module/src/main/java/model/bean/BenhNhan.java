package model.bean;

public class BenhNhan {
    String ma_benh_nhan;
    String ten_benh_nhan;
    String ngay_nhap_vien;
    String ngay_ra_vien;
    String ly_do;
    String ma_benh_an;

    public BenhNhan() {
    }

    public BenhNhan(String ma_benh_nhan, String ten_benh_nhan, String ngay_nhap_vien, String ngay_ra_vien, String ly_do) {
        this.ma_benh_nhan = ma_benh_nhan;
        this.ten_benh_nhan = ten_benh_nhan;
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do = ly_do;
    }

    public BenhNhan(String ma_benh_nhan, String ten_benh_nhan, String ngay_nhap_vien, String ngay_ra_vien, String ly_do, String ma_benh_an) {
        this.ma_benh_nhan = ma_benh_nhan;
        this.ten_benh_nhan = ten_benh_nhan;
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do = ly_do;
        this.ma_benh_an = ma_benh_an;
    }

    public String getMa_benh_nhan() {
        return ma_benh_nhan;
    }

    public void setMa_benh_nhan(String ma_benh_nhan) {
        this.ma_benh_nhan = ma_benh_nhan;
    }

    public String getTen_benh_nhan() {
        return ten_benh_nhan;
    }

    public void setTen_benh_nhan(String ten_benh_nhan) {
        this.ten_benh_nhan = ten_benh_nhan;
    }

    public String getNgay_nhap_vien() {
        return ngay_nhap_vien;
    }

    public void setNgay_nhap_vien(String ngay_nhap_vien) {
        this.ngay_nhap_vien = ngay_nhap_vien;
    }

    public String getNgay_ra_vien() {
        return ngay_ra_vien;
    }

    public void setNgay_ra_vien(String ngay_ra_vien) {
        this.ngay_ra_vien = ngay_ra_vien;
    }

    public String getLy_do() {
        return ly_do;
    }

    public void setLy_do(String ly_do) {
        this.ly_do = ly_do;
    }

    public String getMa_benh_an() {
        return ma_benh_an;
    }

    public void setMa_benh_an(String ma_benh_an) {
        this.ma_benh_an = ma_benh_an;
    }
}
