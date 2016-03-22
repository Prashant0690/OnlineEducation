package org.pt.learn.controller;

import java.security.Principal;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.GResume;
import org.pt.learn.entity.GResumeInfo;
import org.pt.learn.entity.GResumeSkills;
import org.pt.learn.entity.Teacher;
import org.pt.learn.service.ApplicationCommonService;
import org.pt.learn.service.DaoCourseService;
import org.pt.learn.service.DaoTeacherService;
import org.pt.learn.utils.Comments;
import org.pt.learn.utils.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/teacher")
public class TeacherController {
	@ModelAttribute ("teacherData")
	public Teacher constructTeacher(){
		return new Teacher();
	}
	
	@ModelAttribute ("gResumeData")
	private GResume constructGResume (){
		return new GResume();
	}
	
	@ModelAttribute ("gResumeSkillsData")
	private GResumeSkills constructGResumeSkills (){
		return new GResumeSkills();
	}
	
	@ModelAttribute ("gResumeInfoData")
	private GResumeInfo constructGResumeInfo (){
		return new GResumeInfo();
	}
	
	
	
	@Autowired
	private ApplicationCommonService commonService;
	
	@Autowired 
	private DaoTeacherService teacherService;
	
	@Autowired
	private DaoCourseService daoCourseService;
	
	
	
	@RequestMapping ("/registration")
	public String teacherRegistrationForm(Model model, Principal principal){
		Teacher teacher = commonService.findTeachersDetailsUsingUserName(principal.getName());

		if (teacher.getIsTeacherAuthenticate()){
			return "redirect:/teacher/dashboard/home.html";
		}
		model.addAttribute("sexOptions", Snippet.SEX_OPTIONS);
		if (teacher.getTeacherEmail() == null) {
			return "teacherRegistration";
		}
		model.addAttribute("beforeAuthenticationCmt", Comments.TECHER_REG_CMT);
		model.addAttribute("teacherData", teacher);
		return "teacherRegistration";
	}
	
	@RequestMapping (value="/registration", method=RequestMethod.POST)
	public String teacherRegistrationFormSubmission(@ModelAttribute("teacherData") Teacher teacher,
							BindingResult bindingResult, Principal principal){
		teacherService.saveAndUpdateTeacherDetails(teacher , principal.getName());
		return "redirect:/teacher/registration.html";
	}
	
	@RequestMapping ("/dashboard/home")
	public String teacherDashboardHome(Model model){
		model.addAttribute("title", "Teacher Home");
		model.addAttribute("teacherNavBarMenu", "home");
		return "teacherDashboard";
	}
	
	@RequestMapping ("/dashboard/classSchedule")
	public String teacherDashboardClassSchedule(Model model, Principal principal){
		model.addAttribute("title", "Class Schedular");
		model.addAttribute("teacherNavBarMenu", "classSchedule");
		Teacher teacher = teacherService.findTeachersDetailsUsingUserName(principal.getName());
		model.addAttribute("teacherCourseList", teacher.getCoursesTeacher());
		return "teacherDashboard";
	}
	
	@RequestMapping (value="/dashboard/classSchedule", method=RequestMethod.POST)
	public String teacherDashboardClassScheduleAddCourse(@ModelAttribute("courseData") Course course,
						BindingResult bindingResult,Model model, Principal principal){
		if(bindingResult.hasErrors()){
			model.addAttribute("title", "Class Schedular");
			model.addAttribute("teacherNavBarMenu", "classSchedule");
			Teacher teacher = teacherService.findTeachersDetailsUsingUserName(principal.getName());
			model.addAttribute("teacherCourseList", teacher.getCoursesTeacher());
			return "teacherDashboard";
		}
		daoCourseService.addNewCourse(course, principal.getName());
		return "redirect:/teacher/dashboard/classSchedule.html";
	}
	
	@RequestMapping ("/dashboard/personalBranding")
	public String teacherDashboardPersonalBranding(Model model, Principal principal){
		model.addAttribute("title", "Personal Branding");
		model.addAttribute("teacherNavBarMenu", "personalBranding");
		GResume gResume =teacherService.findResumeByUser(principal.getName());
		model.addAttribute("resumeModel", gResume);
		return "teacherDashboard";
	}
	
	@RequestMapping ("/resume/demo")
	public String techResumeDemo(Model model){
		model.addAttribute("showInDemo", "resumeDemo");
		model.addAttribute("backLink", "/teacher/dashboard/personalBranding.html");
		return "resume";
	}
	
	@RequestMapping ("/resume/view")
	public String techResumeMainView(Model model, Principal principal){
		model.addAttribute("showInDemo", "resumeMainTeacher");
		model.addAttribute("backLink", "/teacher/dashboard/personalBranding.html");
		GResume gResume =teacherService.findResumeByUser(principal.getName());
		model.addAttribute("resumeModel", gResume);
		return "resume";
	}
	
	@RequestMapping ("/resume/develop/{newUpdate}")
	public String techResumeDevelop(Model model, Principal principal,
			@PathVariable String newUpdate){
		model.addAttribute("title", "Personal Branding");
		model.addAttribute("teacherNavBarMenu", "personalBranding");
		GResume gResume =teacherService.findResumeByUser(principal.getName());
		model.addAttribute("resumeModel", gResume);
		model.addAttribute("showForm", "resumeForm");
		if("UPDATE".equalsIgnoreCase(newUpdate)){
			model.addAttribute("gResumeData", gResume);
		}
		return "teacherDashboard";
	}
	
	@RequestMapping (value="/resume/develop/{newUpdate}", method=RequestMethod.POST)
	public String techResumeDevelopSave(@ModelAttribute("gResumeData") GResume gResumeData,
			BindingResult bindingResult,@PathVariable String newUpdate,
			Model model, Principal principal){
		if("UPDATE".equalsIgnoreCase(newUpdate)){
			teacherService.updateGResume(gResumeData,principal.getName());
		}else{
			teacherService.saveGResume(gResumeData, principal.getName());
		}
		return "redirect:/teacher/dashboard/personalBranding.html";
	}
	
	@RequestMapping ("/resume/develop/add/info")
	public String techResumeInfo(Model model, Principal principal){
		model.addAttribute("title", "Personal Branding");
		model.addAttribute("teacherNavBarMenu", "personalBranding");
		GResume gResume =teacherService.findResumeByUser(principal.getName());
		model.addAttribute("resumeModel", gResume);
		model.addAttribute("showForm", "resumeInfoForm");
		
		return "teacherDashboard";
	}
	
	@RequestMapping (value="/resume/develop/add/info", method=RequestMethod.POST)
	public String techResumeInfoSave(@ModelAttribute("gResumeInfoData") GResumeInfo gResumeInfoData,
			BindingResult bindingResult,Model model, Principal principal){
		teacherService.saveResumeInfo(gResumeInfoData,principal.getName());
		return "redirect:/teacher/dashboard/personalBranding.html";
	}
	
	@RequestMapping ("/resume/develop/add/skills")
	public String techResumeSkills(Model model, Principal principal){
		model.addAttribute("title", "Personal Branding");
		model.addAttribute("teacherNavBarMenu", "personalBranding");
		GResume gResume =teacherService.findResumeByUser(principal.getName());
		model.addAttribute("resumeModel", gResume);
		model.addAttribute("showForm", "resumeSkillsForm");
		
		return "teacherDashboard";
	}
	
	@RequestMapping (value="/resume/develop/add/skills", method=RequestMethod.POST)
	public String techResumeSkillsSave(@ModelAttribute("gResumeSkillsData") GResumeSkills gResumeSkillsData,
			BindingResult bindingResult,Model model, Principal principal){
		teacherService.saveResumeSkills(gResumeSkillsData,principal.getName());
		return "redirect:/teacher/dashboard/personalBranding.html";
	}
	
/*	@RequestMapping ("/resume/develop")
	public String techResumeDevelop(Model model, Principal principal){
		model.addAttribute("showInDemo", "resumeDevelop");
		model.addAttribute("backLink", "/teacher/dashboard/personalBranding.html");
		model.addAttribute("resumeModel", teacherService.findResumeByUser(principal.getName()));
		return "demo";
	}
	
	@RequestMapping ("/resume/develop/resume/{uniqueId}")
	public String techResumeAdd(Model model, @PathVariable String uniqueId, Principal principal ){
		model.addAttribute("showInDemo", "resumeDevelop");
		model.addAttribute("backLink", "/teacher/dashboard/personalBranding.html");
		model.addAttribute("showForm", "resumeForm");
		try {
			Long id = Long.parseLong(uniqueId);
			model.addAttribute("gResumeData", teacherService.findGResume(id));
		} catch (Exception e) {
			model.addAttribute("gResumeData", new GResume());
		}
		return "demo";
	}
	
	@RequestMapping (value="/resume/develop/resume/{uniqueId}" , method=RequestMethod.POST)
	public String techResumeSave(@ModelAttribute("gResumeData") GResume gResumeData,
			BindingResult bindingResult, Model model, @PathVariable String uniqueId, Principal principal){
		
		try {
			Long id = Long.parseLong(uniqueId);
			teacherService.updateGResume(gResumeData,id);
		} catch (Exception e) {
			teacherService.saveGResume(gResumeData, principal.getName());
		}
		return "redirect:/teacher/resume/develop.html";
	}*/
	
}
