package com.revature.skyrim.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private byte[] password;

  @Column(name = "salt", nullable = false)
  private byte[] salt;

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false)
  private Role role;

  public User() {
  }

  public User(String username, byte[] password, byte[] salt, Role role) {
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.role = role;
  }

  public User(long id, String username, byte[] password, byte[] salt, Role role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.role = role;
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

  public byte[] getPassword() {
    return password;
  }

  public void setPassword(byte[] password) {
    this.password = password;
  }

  public byte[] getSalt() {
    return salt;
  }

  public void setSalt(byte[] salt) {
    this.salt = salt;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", password=" + Arrays.toString(password) + ", salt="
        + Arrays.toString(salt) + ", role=" + role + "]";
  }
}
