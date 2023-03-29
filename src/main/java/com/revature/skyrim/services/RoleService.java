package com.revature.skyrim.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.skyrim.dtos.requests.NewRoleRequest;
import com.revature.skyrim.entities.Role;
import com.revature.skyrim.repositories.RoleRepository;

@Service
public class RoleService {
  private final RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public void createRole(NewRoleRequest req) {
    Role role = new Role();
    role.setName(req.getName());
    roleRepository.save(role);
  }

  public Optional<Role> findRoleByName(String name) {
    Optional<Role> role = roleRepository.findByName(name);

    if (role.isPresent()) {
      return role;
    }

    return Optional.empty();
  }
}
