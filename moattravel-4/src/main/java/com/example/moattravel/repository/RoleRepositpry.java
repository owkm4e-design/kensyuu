package com.example.moattravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.Role;

public interface RoleRepositpry extends JpaRepository<Role, Integer> {

	public Role findByName(String name);
}
