package com.revature.skyrim.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.revature.skyrim.dtos.requests.NewCartItemRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @Column(name = "price", nullable = false)
  private double price;

  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;

  @ManyToOne
  @JsonManagedReference
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  public CartItem() {
  }

  public CartItem(NewCartItemRequest req, Cart cart, Product product) {
    this.quantity = req.getQuantity();
    this.price = req.getPrice();
    this.cart = cart;
    this.product = product;
  }

  public CartItem(int quantity, double price, Cart cart, Product product) {
    this.quantity = quantity;
    this.price = price;
    this.cart = cart;
    this.product = product;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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

  @Override
  public String toString() {
    return "CartItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", cart=" + cart + ", product="
        + product + "]";
  }
}
