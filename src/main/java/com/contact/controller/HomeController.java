package com.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.contact.dao.UserRepository;
import com.contact.entities.User;

import javax.validation.Valid;


@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String landingPage(Model model) {
		model.addAttribute("title", "Smart Contact Manager");
		return "home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "Smart Contact Manager");
		return "home";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping(value = "/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("user", user);
			return "signup";
		}
		user.setEnabled(true);
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(user);
		return "login";

	}
	
	@RequestMapping("/signin")
	public String signin(Model model) {
		model.addAttribute("title", "LogIn Page");
		return "login";
	}
}
