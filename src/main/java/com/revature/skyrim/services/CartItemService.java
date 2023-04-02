package com.revature.skyrim.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.skyrim.dtos.requests.NewCartItemRequest;
import com.revature.skyrim.entities.Cart;
import com.revature.skyrim.entities.CartItem;
import com.revature.skyrim.entities.Product;
import com.revature.skyrim.repositories.CartItemRepository;
import com.revature.skyrim.utils.custom_exceptions.ProductNotFoundException;

@Service
public class CartItemService {
  private final CartItemRepository cartItemRepository;
  private final CartService cartService;
  private final ProductService productService;

  public CartItemService(CartItemRepository cartItemRepository, CartService cartService,
      ProductService productService) {
    this.cartItemRepository = cartItemRepository;
    this.cartService = cartService;
    this.productService = productService;
  }

  public CartItem createCartItem(NewCartItemRequest req) {
    Optional<Cart> cartOptional = cartService.getCartByUserId(req.getUserId());
    Optional<Product> productOptional = productService.getProductById(req.getProductId());

    if (cartOptional.isEmpty()) {
      cartOptional = Optional.of(cartService.createCart(req.getUserId()));
    }

    if (productOptional.isEmpty()) {
      throw new ProductNotFoundException("Product not found");
    }

    CartItem createdCartItem = new CartItem(req, cartOptional.get(), productOptional.get());
    return cartItemRepository.save(createdCartItem);
  }
}
