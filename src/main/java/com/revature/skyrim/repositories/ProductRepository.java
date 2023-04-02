package com.revature.skyrim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.skyrim.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
