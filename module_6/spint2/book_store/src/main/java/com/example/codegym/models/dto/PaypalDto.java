package com.example.codegym.models.dto;


public class PaypalDto {
    String link;

    public PaypalDto(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
