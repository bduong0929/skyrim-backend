package com.revature.skyrim.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.skyrim.dtos.requests.NewCartItemRequest;
import com.revature.skyrim.dtos.requests.UpdateCartItemQuantityRequest;
import com.revature.skyrim.entities.Cart;
import com.revature.skyrim.entities.CartItem;
import com.revature.skyrim.entities.Product;
import com.revature.skyrim.repositories.CartItemRepository;
import com.revature.skyrim.utils.custom_exceptions.ProductNotFoundException;

@Service
@Transactional
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

  /**
   * Creates a new cart item
   * 
   * @param req - NewCartItemRequest containing the cart item information
   * @return - The newly created cart item
   */
  public int createCartItem(NewCartItemRequest req) {
    Optional<Cart> cartOptional = cartService.getCartByUserId(req.getUserId());
    Optional<Product> productOptional = productService.getProductById(req.getProductId());

    if (cartOptional.isEmpty()) {
      cartOptional = Optional.of(cartService.createCart(req.getUserId()));
    }

    if (productOptional.isEmpty()) {
      throw new ProductNotFoundException("Product not found");
    }

    Cart foundCart = cartOptional.get();

    // If the cart item already exists, update the quantity
    for (CartItem cartItem : foundCart.getItems()) {
      if (cartItem.getProduct().getId() == req.getProductId()) {
        cartItem.setQuantity(cartItem.getQuantity() + req.getQuantity());
        cartItemRepository.save(cartItem);
        return cartItemRepository.countCartItems(foundCart.getId());
      }
    }

    CartItem createdCartItem = new CartItem(req, cartOptional.get(), productOptional.get());
    cartItemRepository.save(createdCartItem);
    return cartItemRepository.countCartItems(foundCart.getId());
  }

  /**
   * Gets a cart item by id
   * 
   * @param id - The id of the cart item
   * @return - The cart item
   */
  public Optional<CartItem> getCartItemById(Long id) {
    return cartItemRepository.findById(id);
  }

  /**
   * Updates a cart item quantity
   * 
   * @param req - UpdateCartItemQuantityRequest containing the cart item
   *            information
   * @return count of cart items updated
   */
  public int updateCartItem(UpdateCartItemQuantityRequest req) {
    cartItemRepository.updateCartItemQuantity(req.getQuantity(), req.getId());

    int quantity = cartItemRepository.getQuantityByCartItemId(req.getId());
    if (quantity == 0) {
      cartItemRepository.deleteById(req.getId());
    }

    return cartItemRepository.countCartItems(req.getCartId());
  }
}
