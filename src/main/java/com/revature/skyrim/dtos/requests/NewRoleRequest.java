package com.revature.skyrim.dtos.requests;

public class NewRoleRequest {
  private String name;

  public NewRoleRequest() {
  }

  public NewRoleRequest(String name) {
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
    return "NewRoleRequest [name=" + name + "]";
  }
}
