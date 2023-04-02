package com.revature.skyrim.services;

import org.springframework.stereotype.Service;

import com.revature.skyrim.entities.Product;
import com.revature.skyrim.repositories.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product getProductById(Long id) {
    return productRepository.findById(id).get();
  }
}
