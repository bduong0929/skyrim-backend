package com.revature.skyrim.dtos.responses;

import com.revature.skyrim.entities.User;

public class Principal {
  private long id;
  private String username;

  private String role;

  private String token;

  public Principal() {
  }

  public Principal(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.role = user.getRole().getName();
  }

  public Principal(long id, String username, String role) {
    this.id = id;
    this.username = username;
    this.role = role;
  }

  public Principal(long id, String username, String role, String token) {
    this.id = id;
    this.username = username;
    this.role = role;
    this.token = token;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "Principal [id=" + id + ", username=" + username + ", role=" + role + ", token=" + token + "]";
  }
}
