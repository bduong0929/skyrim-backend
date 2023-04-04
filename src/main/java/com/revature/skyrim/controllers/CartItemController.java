package com.revature.skyrim.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.skyrim.dtos.requests.NewCartItemRequest;
import com.revature.skyrim.dtos.requests.UpdateCartItemQuantityRequest;
import com.revature.skyrim.entities.CartItem;
import com.revature.skyrim.services.CartItemService;

@CrossOrigin
@RestController
@RequestMapping("/cartitem")
public class CartItemController {
  private final CartItemService cartItemService;

  public CartItemController(CartItemService cartItemService) {
    this.cartItemService = cartItemService;
  }

  @PostMapping("/create")
  public ResponseEntity<Integer> createCartItem(@RequestBody NewCartItemRequest req) {
    return ResponseEntity.status(HttpStatus.CREATED).body(cartItemService.createCartItem(req));
  }

  /**
   * Update cart item quantity
   * 
   * @param UpdateCartItemQuantityRequest req
   * @return count of cart items updated
   */
  @PutMapping("/update")
  public ResponseEntity<Integer> updateCartItem(@RequestBody UpdateCartItemQuantityRequest req) {
    return ResponseEntity.status(HttpStatus.OK).body(cartItemService.updateCartItem(req));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CartItem> getCartItemById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(cartItemService.getCartItemById(id).get());
  }
}
