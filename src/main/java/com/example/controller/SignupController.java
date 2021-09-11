package com.example.controller;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.form.SignupForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.*;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

	final Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private UserApplicationService userApplicaitonService; 
	
	/*Display the user signup screen*/
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale,@ModelAttribute SignupForm form) {
		//Getgender
		Map<String, Integer> genderMap = userApplicaitonService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		//model.addAttribute("signupForm",form);
		//Transistion to usersignup screen
		return "user/signup";
	}
	
	/*User signup processs*/
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, 
			@ModelAttribute @Validated SignupForm form, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return getSignup(model, locale, form);
		}
		logger.info(form.toString());
		//redirect to loginscreen
		return "redirect:/login";
	}
	
}
