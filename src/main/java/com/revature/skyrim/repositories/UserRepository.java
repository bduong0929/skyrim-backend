package com.revature.skyrim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.skyrim.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Query("SELECT u.username FROM User u WHERE u.username = ?1")
  String findUsername(String username);
}
