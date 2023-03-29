package com.revature.skyrim.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.skyrim.dtos.requests.NewRoleRequest;
import com.revature.skyrim.services.RoleService;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping("/create")
  public ResponseEntity<?> createRole(@RequestBody NewRoleRequest req) {
    roleService.createRole(req);

    // Set the response status to 201 (Created) and return a success message
    return ResponseEntity.status(HttpStatus.CREATED).body("Role created successfully!");
  }
}
