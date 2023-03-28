package com.revature.skyrim.services;

import org.springframework.stereotype.Service;

import com.revature.skyrim.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}
