package com.revature.skyrim.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.skyrim.dtos.requests.NewCartItemRequest;
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
  public ResponseEntity<?> createCartItem(@RequestBody NewCartItemRequest req) {
    cartItemService.createCartItem(req);
    return ResponseEntity.status(HttpStatus.CREATED).body("Cart Item created successfully!");
  }
}
