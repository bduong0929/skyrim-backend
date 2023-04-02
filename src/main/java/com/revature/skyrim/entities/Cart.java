package com.revature.skyrim.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<CartItem> items;

  public Cart() {
  }

  public Cart(long id, User user, List<CartItem> items) {
    this.id = id;
    this.user = user;
    this.items = items;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<CartItem> getItems() {
    return items;
  }

  public void setItems(List<CartItem> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "Cart [id=" + id + ", user=" + user + ", items=" + items + "]";
  }
}
