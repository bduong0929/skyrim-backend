package com.revature.skyrim.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "created_at", nullable = false)
  private Timestamp createdAt;

  @Column(name = "total_cost", nullable = false)
  private double totalCost;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public Order() {
  }

  public Order(Timestamp createdAt, double totalCost, User user) {
    this.createdAt = createdAt;
    this.totalCost = totalCost;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(double totalCost) {
    this.totalCost = totalCost;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", createdAt=" + createdAt + ", totalCost=" + totalCost + ", user=" + user + "]";
  }
}
