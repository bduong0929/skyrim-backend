package com.revature.skyrim.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.skyrim.entities.Product;
import com.revature.skyrim.repositories.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }
}
