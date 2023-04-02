package com.revature.skyrim.dtos.requests;

public class NewCartItemRequest {
  private double price;
  private int quantity;
  private Long userId;
  private Long productId;

  public NewCartItemRequest() {
  }

  public NewCartItemRequest(double price, int quantity, Long userId, Long productId) {
    this.price = price;
    this.quantity = quantity;
    this.userId = userId;
    this.productId = productId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  @Override
  public String toString() {
    return "NewCartItemRequest [price=" + price + ", quantity=" + quantity + ", userId=" + userId + ", productId="
        + productId + "]";
  }
}
