package com.revature.skyrim.dtos.responses;

import com.revature.skyrim.entities.Role;
import com.revature.skyrim.entities.User;

public class Principal {
  private long id;
  private String username;
  private Role role;
  private String token;

  public Principal() {
  }

  public Principal(long id, String username, Role role) {
    this.id = id;
    this.username = username;
    this.role = role;
  }

  public Principal(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.role = user.getRole();
  }

  public Principal(long id, String username, Role role, String token) {
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "Principal [id=" + id + ", username=" + username + ", role=" + role + ", token=" + token + "]";
  }
}
