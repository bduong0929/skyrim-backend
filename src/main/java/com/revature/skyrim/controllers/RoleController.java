package com.revature.skyrim.controllers;

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
  public void createRole(@RequestBody NewRoleRequest req) {
    roleService.createRole(req);
  }
}
