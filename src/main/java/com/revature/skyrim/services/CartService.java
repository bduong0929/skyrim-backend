package com.revature.skyrim.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.skyrim.entities.Cart;
import com.revature.skyrim.entities.User;
import com.revature.skyrim.repositories.CartRepository;
import com.revature.skyrim.utils.custom_exceptions.UserNotFoundException;

@Service
public class CartService {
  private final CartRepository cartRepository;
  private final UserService userService;

  public CartService(CartRepository cartRepository, UserService userService) {
    this.cartRepository = cartRepository;
    this.userService = userService;
  }

  /**
   * Creates a new cart for the user
   * 
   * @param userId the id of the user
   * @return the created cart
   */
  public Cart createCart(Long userId) {
    Optional<User> userOptional = userService.getUserById(userId);

    if (userOptional.isEmpty()) {
      throw new UserNotFoundException("User not found");
    }

    Cart createdCart = new Cart(userOptional.get());
    return cartRepository.save(createdCart);
  }

  /**
   * Gets the cart by the user id
   * 
   * @param userId the id of the user
   * @return the cart
   */
  public Optional<Cart> getCartByUserId(Long userId) {
    return cartRepository.findCartByUserId(userId);
  }
}
