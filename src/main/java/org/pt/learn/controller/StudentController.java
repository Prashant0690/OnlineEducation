package org.pt.learn.controller;

import java.security.Principal;

import org.pt.learn.service.ApplicationCommonService;
import org.pt.learn.service.DaoStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/student")
public class StudentController {
	

	@Autowired
	private ApplicationCommonService appCommonService;
	
	@Autowired
	private DaoStudentService studentService;
	
	@RequestMapping ("/studentDashboard")
	public String studentDashboard(Model model,Principal principal){
		model.addAttribute("studentM", appCommonService.findOneStudentByUserName(principal.getName()));
		return "studentDashboard";
	}
	
	
	
	

}
