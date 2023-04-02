package com.revature.skyrim.dtos.requests;

public class NewCategoryRequest {
  private String name;

  public NewCategoryRequest() {
  }

  public NewCategoryRequest(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "NewCategoryRequest [name=" + name + "]";
  }
}
