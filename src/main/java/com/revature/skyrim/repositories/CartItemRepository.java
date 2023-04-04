package com.revature.skyrim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.skyrim.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

  /**
   * Count the number of cart items in a cart
   * 
   * @param i
   * @return
   */
  @Query(value = "SELECT COUNT(*) FROM cart_items WHERE cart_id = ?1", nativeQuery = true)
  int countCartItems(Long i);

  /**
   * Update cart item quantity
   * 
   * @param quantity
   * @param cartItemId
   */
  @Modifying
  @Query(value = "UPDATE cart_items SET quantity = ?1 WHERE id = ?2", nativeQuery = true)
  void updateCartItemQuantity(int quantity, Long cartItemId);

  /**
   * Return quantity from cart item id
   * 
   * @param cartItemId
   * @return quantity
   */
  @Query(value = "SELECT quantity FROM cart_items WHERE id = ?1", nativeQuery = true)
  int getQuantityByCartItemId(Long cartItemId);
}
