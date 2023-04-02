package com.revature.skyrim.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @Column(name = "price", nullable = false)
  private double price;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  public OrderItem() {
  }

  public OrderItem(int quantity, double price, Order order, Product product) {
    this.quantity = quantity;
    this.price = price;
    this.order = order;
    this.product = product;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", order=" + order + ", product="
        + product + "]";
  }
}
