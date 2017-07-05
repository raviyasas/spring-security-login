package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.User;
import com.app.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

//	View registration page
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExist = userService.findByEmail(user.getEmail());

		if (userExist != null) {
			bindingResult.rejectValue("email", "email.user", "This email is already registered");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("success message", "User has been registered");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("register");
		}

		return modelAndView;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
