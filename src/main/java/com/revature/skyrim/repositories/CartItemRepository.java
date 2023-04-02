package com.revature.skyrim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.skyrim.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
