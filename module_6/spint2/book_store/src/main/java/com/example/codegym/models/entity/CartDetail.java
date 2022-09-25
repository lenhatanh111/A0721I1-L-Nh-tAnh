package com.example.codegym.models.entity;

import javax.persistence.*;

@Entity
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private boolean isPayed;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CartDetail() {
    }

    public CartDetail(Long id, Integer quantity, boolean isPayed, Cart cart, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.isPayed = isPayed;
        this.cart = cart;
        this.product = product;
    }

    public CartDetail(Integer quantity, boolean isPayed, Cart cart, Product product) {
        this.quantity = quantity;
        this.isPayed = isPayed;
        this.cart = cart;
        this.product = product;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}
