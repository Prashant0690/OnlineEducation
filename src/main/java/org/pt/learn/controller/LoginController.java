package org.pt.learn.controller;

import org.pt.learn.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	

	
	@ModelAttribute ("users")
	public Users constructUser(){
		return new Users();
	}
	
	@RequestMapping ("/login")
	public String login(){
		return "login";
	}

	
}
