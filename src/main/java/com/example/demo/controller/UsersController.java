package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersController {
	UsersService servies;
	
	
public UsersController(UsersService servies) {
		super();
		this.servies = servies;
}
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users users) {
		boolean userStatus = servies.emailExists(users.getEmail());
			if(userStatus == false) {
				servies.addUser(users);
				System.out.println("user added");
			}else {
				System.out.println("user already exists");
			}
		return "home";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
			@RequestParam("password")String password,
			HttpSession session) {
		if(servies.validateUser(email,password)==true) {
			String role =servies.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminHome";
			}
			else{
				return "CustomerHome";
			}
		}
		else {
			return "login";
		}
	}
//	@GetMapping("/pay")
//	public String pay(@RequestParam String email) {
//		boolean paymentStatus = false;
//		if(paymentStatus==true) {
//			Users users=servies.getuUsers(email);
//			users.setPremium(true);
//			servies.updateUsers(users);
//		}
//		return "login";
//	}
	@GetMapping("/logout")
	public String  logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	
}
