package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByRole(String role);
}
