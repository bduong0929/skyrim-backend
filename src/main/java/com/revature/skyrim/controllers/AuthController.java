package com.revature.skyrim.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.skyrim.dtos.requests.NewRegisterRequest;
import com.revature.skyrim.services.UserService;
import com.revature.skyrim.utils.custom_exceptions.InvalidRegisterException;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody NewRegisterRequest req) {
    String username = req.getUsername();
    String password = req.getPassword1();

    // If the username is invalid, return a 400 (Bad Request) response
    if (!userService.isValidUsername(username)) {
      throw new InvalidRegisterException(
          "Username must be between 8 and 20 characters and contain only letters");
    }

    // If the username is already taken, return a 400 (Bad Request) response
    if (!userService.isUniqueUsername(username)) {
      throw new InvalidRegisterException("Username is already taken");
    }

    // If the password is invalid, return a 400 (Bad Request) response
    if (!userService.isValidPassword(password)) {
      throw new InvalidRegisterException(
          "Password must be at least 8 characters and contain at least one letter and one number");
    }

    // If the passwords don't match, return a 400 (Bad Request) response
    if (!userService.doPasswordsMatch(req.getPassword1(), req.getPassword2())) {
      throw new InvalidRegisterException("Passwords do not match");
    }

    try {
      userService.register(req);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
  }
}
