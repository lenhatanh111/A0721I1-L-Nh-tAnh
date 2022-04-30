package com.codegym.entity;

public class Mailbox {
    String language;
    String page_size;
    boolean enable;
    String signature;

    public Mailbox() {
    }

    public Mailbox(String language, String page_size, boolean enable, String signature) {
        this.language = language;
        this.page_size = page_size;
        this.enable = enable;
        this.signature = signature;

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


}
