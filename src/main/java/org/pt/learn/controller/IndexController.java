package org.pt.learn.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.Student;
import org.pt.learn.service.ApplicationCommonService;
import org.pt.learn.session.service.UserSessionData;
import org.pt.learn.utils.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private ApplicationCommonService appCommonService;
	
	@Autowired
	private UserSessionData userSessionData;
	
	@RequestMapping ("/")
	private String index1(Model model, HttpSession httpSession ){
		model.addAttribute("headerM", "index");
		httpSession.setAttribute("ting", "prashant tiwari");
		userSessionData.setX(100);
		userSessionData.setY(200);

		return "index";
	}
	
	@RequestMapping ("/index")
	private String index2(Model model){
		model.addAttribute("headerM", "index");
		return "index";
	}
	
	@RequestMapping ("/courses/all")
	public String all(Model model, HttpSession httpSession){
		model.addAttribute("headerM", "allCourses");
		model.addAttribute("allCoursesM", appCommonService.findAllCourse());
		model.addAttribute("SubjectFilterLisr", Snippet.LIST_SUBJECTS);
		System.out.println(httpSession.getAttribute("ting"));
		System.out.println("X+Y = "+ userSessionData.getX()+userSessionData.getY());
	
		return "indexAllCourses";
	}
	
	
	/*@RequestMapping ("/index/enroll/page/{courseId}")
	public String enrollPage1(Model model, @PathVariable Long courseId ){
		System.out.println(1);
		model.addAttribute("descriptionList", appCommonService.findAllDescriptionForGivenCourseId(courseId) );
		return "indexEnrollPage";
	}*/
	
	@RequestMapping ("/index/enroll/page/{courseId}")
	public String enrollPage2(Model model, @PathVariable Long courseId, Principal principal){
		boolean regStatus = false;
		Course course = appCommonService.findOneCourse(courseId);
		if(principal == null){
			model.addAttribute("authUrl", "/auth/index/enroll/page/"+courseId+".html");
		} else {
			model.addAttribute("joinCourse", "/auth/index/enroll/page/"+courseId+".html");
			Student student = appCommonService.findOneStudentByUserName(principal.getName());
			for(Course c : student.getCoursesStudent()){
				if (c.getCourseId() == courseId){
					regStatus = true;
					/*if (course.getCourseStartDate().compareTo(new Date())<0){*/
					if ((new Date().after(course.getCourseStartDate()))){
						model.addAttribute("classStarted", true);
						model.addAttribute("courseURL", "/home/classroom/course/"+courseId+"/"+course.getCourseType()+".html" );
					}else{
						model.addAttribute("classStarted", false);
						model.addAttribute("courseURL", "Course "+course.getCourseName()+"will be starting Soon on "+course.getCourseStartDate());
					}
					break;
				} }
		}
		model.addAttribute("userCourseRegistrationStatus", regStatus);
		model.addAttribute("descriptionList", appCommonService.findAllDescriptionForGivenCourseId(courseId) );
		return "indexEnrollPage";
	}
	
	@RequestMapping ("/auth/index/enroll/page/{courseId}")
	public String enrollPageWithAuthentication2(Model model, @PathVariable Long courseId, Principal principal){
		boolean regStatus = false;
		Course course = appCommonService.findOneCourse(courseId);
		
		if(principal == null){
			model.addAttribute("authUrl", "/auth/index/enroll/page/"+courseId+".html");
		} else {
			model.addAttribute("joinCourse", "/auth/register/"+principal.getName()+"/in/"+courseId+".html");
			Student student = appCommonService.findOneStudentByUserName(principal.getName());
			for(Course c : student.getCoursesStudent()){
				if (c.getCourseId() == courseId){
					regStatus = true;
					/*if (course.getCourseStartDate().compareTo(new Date())<0){*/
					if ((new Date().after(course.getCourseStartDate()))){
						model.addAttribute("classStarted", true);
						model.addAttribute("courseURL", "/home/classroom/course/"+courseId+"/"+course.getCourseType()+".html" );
					}else{
						model.addAttribute("classStarted", false);
						model.addAttribute("courseURL", "Course "+course.getCourseName()+"will be starting Soon on "+course.getCourseStartDate());
					}
					break;
				} }
		}
		model.addAttribute("userCourseRegistrationStatus", regStatus);
		model.addAttribute("descriptionList", appCommonService.findAllDescriptionForGivenCourseId(courseId) );
		return "indexEnrollPage";
	}
	
	@RequestMapping ("/auth/register/{userName}/in/{courseId}")
	public String courseRegistration(Model model, @PathVariable String userName,
			@PathVariable Long courseId, Principal principal){
		
		appCommonService.joinCourseStudent(courseId, principal.getName() );
		return "redirect:/auth/index/enroll/page/"+courseId+".html";
	}
	
	@RequestMapping ("/home/classroom/course/{courseId}/{courseType}")
	public String courseHomePage(Model model, @PathVariable Long courseId,@PathVariable String courseType  ){
		
		Course course = appCommonService.findOneCourse(courseId);
		course.setDescriptionsList(appCommonService.findAllDescriptionForGivenCourseId(course));
		if(course.getCourseType().equalsIgnoreCase(Snippet.LIST_COURSE_TYPE.get(0))){
			model.addAttribute("typeMagazine", appCommonService.findCourseTypeModelMagazine(course.getCourseTypeId()));
		}
		if (course.getLatestUpdateId()!= null){
			model.addAttribute("latestUpdate", appCommonService.latestUpdate(course.getLatestUpdateId()));
		}
		model.addAttribute("courseModel", course);
		model.addAttribute("magazineMenu", "Cover");
		model.addAttribute("magazinesubMenu", "");
		return "theMagazineHome";
	}
	
	
	
}
