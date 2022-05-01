package com.codegym.model;

public class Product {
    String id;
    String name;
    String cost;
    String description;
    String producer;

    public Product() {
    }

    public Product(String id, String name, String cost, String description, String producer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
