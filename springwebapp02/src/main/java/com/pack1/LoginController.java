package com.pack1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	@PostMapping("/login")
	public String processLogin(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model model) {
		if (username.equalsIgnoreCase("Srikanth") && password.equals("password")) {
			model.addAttribute("username", username);
			return "welcome";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}


}
