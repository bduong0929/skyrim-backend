package com.revature.skyrim.dtos.requests;

public class UpdateCartItemQuantityRequest {
  private Long id;
  private int quantity;
  private Long cartId;

  public UpdateCartItemQuantityRequest() {
  }

  public UpdateCartItemQuantityRequest(Long id, int quantity, Long cartId) {
    this.id = id;
    this.quantity = quantity;
    this.cartId = cartId;
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

  public Long getCartId() {
    return cartId;
  }

  public void setCartId(Long cartId) {
    this.cartId = cartId;
  }

  @Override
  public String toString() {
    return "UpdateCartItemQuantityRequest [id=" + id + ", quantity=" + quantity + ", cartId=" + cartId + "]";
  }
}
