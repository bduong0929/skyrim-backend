package com.revature.skyrim.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.skyrim.dtos.requests.NewLoginRequest;
import com.revature.skyrim.dtos.requests.NewRegisterRequest;
import com.revature.skyrim.dtos.responses.Principal;
import com.revature.skyrim.services.TokenService;
import com.revature.skyrim.services.UserService;
import com.revature.skyrim.utils.custom_exceptions.InvalidLoginException;
import com.revature.skyrim.utils.custom_exceptions.InvalidRegisterException;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final UserService userService;
  private final TokenService tokenService;

  public AuthController(UserService userService, TokenService tokenService) {
    this.userService = userService;
    this.tokenService = tokenService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody NewRegisterRequest req) throws NoSuchAlgorithmException {
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

    userService.register(req);
    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
  }

  @PostMapping("/login")
  public ResponseEntity<Principal> login(@RequestBody NewLoginRequest req)
      throws NoSuchAlgorithmException, InvalidLoginException {

    Optional<Principal> principalOptional = userService.login(req);

    if (principalOptional.isPresent()) {
      Principal principal = principalOptional.get();

      String token = tokenService.generateToken(principal);
      principal.setToken(token);

      return ResponseEntity.ok(principal);
    } else {
      throw new InvalidLoginException("Invalid credentials");
    }
  }

  @ExceptionHandler(NoSuchAlgorithmException.class)
  public ResponseEntity<Map<String, Object>> handleNoSuchAlgorithmException(NoSuchAlgorithmException e) {
    e.printStackTrace();
    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("timestamp", System.currentTimeMillis());
    errorResponse.put("message", "Internal server error");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  @ExceptionHandler(InvalidLoginException.class)
  public ResponseEntity<Map<String, Object>> handleInvalidLoginException(InvalidLoginException e) {
    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("timestamp", new Date());
    errorResponse.put("message", e.getMessage());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
  }

  @ExceptionHandler(InvalidRegisterException.class)
  public ResponseEntity<Map<String, Object>> handleInvalidRegisterException(InvalidRegisterException e) {
    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("timestamp", new Date());
    errorResponse.put("message", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
