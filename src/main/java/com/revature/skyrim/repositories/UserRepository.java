package com.revature.skyrim.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.skyrim.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  // Find a username by username
  @Query("SELECT u.username FROM User u WHERE u.username = ?1")
  String findUsernameByUsername(String username);

  // Find a user by username
  @Query("SELECT u FROM User u WHERE u.username = ?1")
  Optional<User> findUserByUsername(String username);
}
