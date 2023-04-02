package com.revature.skyrim.services;

import java.util.List;

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

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public Category getCategoryById(Long id) {
    return categoryRepository.findById(id).get();
  }
}
