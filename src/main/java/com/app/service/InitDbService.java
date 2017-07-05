package com.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Role;
import com.app.repository.RoleRepository;

@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void init() {

		if (roleRepository.findByRole("ROLE_ADMIN") == null) {

			// Adding a role for Admin
			Role roleAdmin = new Role();
			roleAdmin.setRole("ROLE_ADMIN");
			roleRepository.save(roleAdmin);

			// Adding a role for User
			Role roleUser = new Role();
			roleUser.setRole("ROLE_USER");
			roleRepository.save(roleUser);
		}

	}
}
