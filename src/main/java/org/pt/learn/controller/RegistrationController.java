package org.pt.learn.controller;

import javax.validation.Valid;

import org.pt.learn.entity.Users;
import org.pt.learn.service.DaoStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	
	@ModelAttribute ("users")
	public Users constructUser(){
		return new Users();
	}
	
	@Autowired
	private DaoStudentService studentService;
	
	@RequestMapping ("/registration/newstudent")
	public String registration(){
		return "registration";
	}
	
	@RequestMapping (value="/registration/newstudent", method=RequestMethod.POST)
	public String doRegistration(@Valid @ModelAttribute("users") Users users , BindingResult result ){
		if (result.hasErrors()){
			return "registration";
		}
		studentService.saveStudent(users);
		return "registration";
	}

}
