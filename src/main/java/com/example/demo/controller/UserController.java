package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;

@Controller
public class UserController {
	
	
	@Autowired
	public UserRepo urepo;
	
	
	@GetMapping("/home")
	   String home(Model model) {			
		model.addAttribute("registrationForm", new User());	
		model.addAttribute("loginForm", new User());	
		return "home";
	}
	
	
	
	
	
	@PostMapping("/registration")
	   String registersave(Model model, @ModelAttribute("registrationForm") User userForm) {
		
		urepo.save(userForm);		
		
		return "home";
	}
	
}
