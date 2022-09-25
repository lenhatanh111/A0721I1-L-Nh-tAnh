package com.example.codegym.models.dto;

public class TotalDto {
    Long total;
    Long vat;
    Long price;


    public TotalDto() {
    }

    public TotalDto(Long total, Long vat, Long price ) {
        this.total = total;
        this.vat = vat;
        this.price = price;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getVat() {
        return vat;
    }

    public void setVat(Long vat) {
        this.vat = vat;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
}
