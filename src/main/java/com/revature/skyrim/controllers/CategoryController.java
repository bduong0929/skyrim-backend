package com.revature.skyrim.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.skyrim.dtos.requests.NewCategoryRequest;
import com.revature.skyrim.entities.Category;
import com.revature.skyrim.services.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping("/create")
  public ResponseEntity<?> createCategory(@RequestBody NewCategoryRequest req) {
    categoryService.createCategory(req);
    return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully!");
  }

  @GetMapping("/all")
  public ResponseEntity<?> getAllCategories() {
    return ResponseEntity.ok(categoryService.getAllCategories());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(categoryService.getCategoryById(id));
  }
}
