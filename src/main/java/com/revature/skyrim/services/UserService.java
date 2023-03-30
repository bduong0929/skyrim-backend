package com.revature.skyrim.services;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.skyrim.dtos.requests.NewLoginRequest;
import com.revature.skyrim.dtos.requests.NewRegisterRequest;
import com.revature.skyrim.dtos.requests.NewRoleRequest;
import com.revature.skyrim.dtos.responses.Principal;
import com.revature.skyrim.entities.Role;
import com.revature.skyrim.entities.User;
import com.revature.skyrim.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final SecurityService securityService;
  private final RoleService roleService;

  public UserService(UserRepository userRepository, SecurityService securityService, RoleService roleService) {
    this.userRepository = userRepository;
    this.securityService = securityService;
    this.roleService = roleService;
  }

  public void register(NewRegisterRequest req) throws NoSuchAlgorithmException {
    byte[] generateSalt = securityService.generateSalt();
    byte[] hashedPassword = securityService.hashingMethod(req.getPassword1(), generateSalt);

    Optional<Role> role = roleService.findRoleByName("DEFAULT");

    if (!role.isPresent()) {
      roleService.createRole(new NewRoleRequest("DEFAULT"));
      role = roleService.findRoleByName("DEFAULT");
    }

    User createdUser = new User(req.getUsername(), hashedPassword, generateSalt, role.get());
    userRepository.save(createdUser);
  }

  public Optional<Principal> login(NewLoginRequest req) throws NoSuchAlgorithmException {
    Optional<User> userOptional = userRepository.findUserByUsername(req.getUsername());

    if (userOptional.isPresent()) {
      User foundUser = userOptional.get();
      byte[] actualPassword = securityService.hashingMethod(req.getPassword(), foundUser.getSalt());

      if (securityService.isSamePassword(foundUser.getPassword(), actualPassword)) {
        return Optional.of(new Principal(foundUser));
      }
    }

    return Optional.empty();
  }

  public boolean isValidUsername(String username) {
    return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
  }

  public boolean isUniqueUsername(String username) {
    return userRepository.findUsernameByUsername(username) == null;
  }

  public boolean isValidPassword(String password) {
    return password
        .matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
  }

  public boolean doPasswordsMatch(String password1, String password2) {
    return password1.equals(password2);
  }
}
