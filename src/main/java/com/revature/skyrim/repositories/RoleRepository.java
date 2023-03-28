package com.revature.skyrim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.skyrim.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
