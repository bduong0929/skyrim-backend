package com.revature.skyrim.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.skyrim.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  /**
   * Find a cart by the user id
   * 
   * @param userId the user id
   * @return
   */
  @Query("SELECT c FROM Cart c WHERE c.user.id = ?1")
  Optional<Cart> findCartByUserId(Long userId);
}
