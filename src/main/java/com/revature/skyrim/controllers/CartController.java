package com.revature.skyrim.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.skyrim.entities.Cart;
import com.revature.skyrim.services.CartService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  /**
   * Get cart by user id
   * 
   * @param id user id
   * @return cart by user id
   */
  @GetMapping("/{id}")
  public ResponseEntity<Cart> getCartByUserId(@PathVariable("id") Long id) {
    return ResponseEntity.ok(cartService.getCartByUserId(id).get());
  }
}
