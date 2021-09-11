package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	/*Display login screen*/
	@GetMapping("/login")
	public String getLogin() {
		return "loginFolder/login";
	}
}
