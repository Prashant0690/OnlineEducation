package org.pt.learn.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.pt.learn.entity.Course;
import org.pt.learn.service.CourseDevelopmentService;
import org.pt.learn.utils.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/course/development")
public class CourseDevelopmentController {
	
	@InitBinder
	public void initBinder (WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/mm");
		binder.registerCustomEditor(Date.class, "courseStartDate", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(Date.class, "courseEndDate", new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute ("courseData")
	public Course constructCourse(){
		return new Course();
	}
	
	@Autowired
	private CourseDevelopmentService courseDevelopmentService;
	
	
	/*COURSE ADD AND UPDATE*/
	
	@RequestMapping ("/addNewCourse/classroom")
	public String addNewCourse(Model model){
		model.addAttribute("subjectOptions",Snippet.LIST_SUBJECTS);
		model.addAttribute("typeOptions",Snippet.LIST_COURSE_TYPE);
		model.addAttribute("categoryOptions",Snippet.LIST_COURSE_CATEGORY);
		model.addAttribute("showMenu",false );
		model.addAttribute("showForm",true );
		model.addAttribute("showData",false );
		model.addAttribute("displayCourseModel","");
		return "addCourse";
	}
	
	@RequestMapping (value="/addNewCourse/classroom", method=RequestMethod.POST)
	public String teacherDashboardClassScheduleAddCourse(@Valid @ModelAttribute("courseData") Course course,
						BindingResult bindingResult,Model model, Principal principal){
		if(bindingResult.hasErrors()){
			model.addAttribute("subjectOptions",Snippet.LIST_SUBJECTS);
			model.addAttribute("typeOptions",Snippet.LIST_COURSE_TYPE);
			model.addAttribute("categoryOptions",Snippet.LIST_COURSE_CATEGORY);
			model.addAttribute("courseData", course);
			model.addAttribute("showMenu",false );
			model.addAttribute("showForm",true );
			model.addAttribute("showData",false );
			model.addAttribute("displayCourseModel","");
			return "addCourse";
		}
		courseDevelopmentService.addNewCourse(course, principal.getName());
		return "redirect:/teacher/dashboard/classSchedule.html";
	}
	
	@RequestMapping ("/classroom/progress/{courseId}/{courseName}/{courseType}")
	public String maintainCourse(Model model, @PathVariable Long courseId,
			@PathVariable String courseName , @PathVariable String courseType){
		Course courseDB =courseDevelopmentService.findOneCourse(courseId);
		
		model.addAttribute("subjectOptions",Snippet.LIST_SUBJECTS);
		model.addAttribute("typeOptions",Snippet.LIST_COURSE_TYPE);
		model.addAttribute("categoryOptions",Snippet.LIST_COURSE_CATEGORY);
		
		model.addAttribute("current","course" );
		model.addAttribute("showMenu",true );
		model.addAttribute("showForm",false );
		model.addAttribute("showData",true );
		model.addAttribute("displayCourseModel", "");
		
		model.addAttribute("courseM", courseDB);
		
		return "addCourse" ;
	}
	
	@RequestMapping ("/classroom/progress/{courseId}/{courseName}/{courseType}/update")
	public String maintainCourseUpdate(Model model, @PathVariable Long courseId){
		Course courseDB =courseDevelopmentService.findOneCourse(courseId);
		
		model.addAttribute("subjectOptions",Snippet.LIST_SUBJECTS);
		model.addAttribute("typeOptions",Snippet.LIST_COURSE_TYPE);
		model.addAttribute("categoryOptions",Snippet.LIST_COURSE_CATEGORY);
		
		model.addAttribute("current","course" );
		model.addAttribute("showMenu",true );
		model.addAttribute("showForm",true );
		model.addAttribute("showData",true );
		model.addAttribute("displayCourseModel", "");
		
		model.addAttribute("courseM", courseDB);
		model.addAttribute("courseData", courseDB);
		
		return "addCourse";
	}
	
	@RequestMapping (value="/classroom/progress/{courseId}/{courseName}/{courseType}/update", method=RequestMethod.POST)
	public String maintainCourseSaveUpdate(@Valid @ModelAttribute("courseData") Course course,
			BindingResult bindingResult,Model model, @PathVariable Long courseId,
			@PathVariable String courseName , @PathVariable String courseType){
		
		courseDevelopmentService.updateCourse(course, courseId);
		
		return "redirect:/course/development/classroom/progress/"+courseId+"/"+courseName+"/"+courseType+".html";
	}
	
	
	
}	
