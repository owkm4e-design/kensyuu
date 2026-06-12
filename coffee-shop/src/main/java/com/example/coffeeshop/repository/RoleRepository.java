package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRoleName(String roleName);
}
