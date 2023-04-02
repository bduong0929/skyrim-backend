package com.revature.skyrim.services;

import org.springframework.stereotype.Service;

import com.revature.skyrim.dtos.requests.NewCategoryRequest;
import com.revature.skyrim.entities.Category;
import com.revature.skyrim.repositories.CategoryRepository;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public void createCategory(NewCategoryRequest req) {
    Category createdCategory = new Category(req);
    categoryRepository.save(createdCategory);
  }
}
