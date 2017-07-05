package com.app.service;

import com.app.model.User;

public interface UserService {

	public void saveUser(User user);

	public User findByEmail(String email);

}
