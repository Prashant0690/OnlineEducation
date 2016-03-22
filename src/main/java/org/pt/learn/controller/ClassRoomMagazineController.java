package org.pt.learn.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.Magazine;
import org.pt.learn.entity.MagazinePage;
import org.pt.learn.entity.MagazinePageDevelopment;
import org.pt.learn.entity.MagazineQuizQues;
import org.pt.learn.model.QuizDataModel;
import org.pt.learn.service.FileService;
import org.pt.learn.service.MagazineCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("classroom/TheMagazineCourse/{courseId}/{courseName}")
public class ClassRoomMagazineController {
	
	@ModelAttribute ("magPageQuizData")
	public QuizDataModel constructQuizDataModel(){
		return new QuizDataModel();
	}
	
	@Autowired
	private MagazineCourseService magazineCourseService;
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String magazineHomePage(Model model, @PathVariable Long courseId, @PathVariable String courseName){
		Course course = magazineCourseService.findCourseByCourseId(courseId);
		course.setDescriptionsList(magazineCourseService.findAllDescriptionForACourse(course));
		
		model.addAttribute("typeMagazine", magazineCourseService.findOneMagazineMagazineId(course.getCourseTypeId()));
		if (course.getLatestUpdateId()!= null){
			model.addAttribute("latestUpdate", magazineCourseService.findOneCourseUpdate(course.getLatestUpdateId()));
		}
		model.addAttribute("courseModel", course);
		model.addAttribute("magazineMenu", "Cover");
		model.addAttribute("magazinesubMenu", "");
		return "theMagazineHome";
	}
	
	@RequestMapping("/all/updates")
	public String magazineUpdates(Model model, @PathVariable Long courseId, @PathVariable String courseName){
		Course course = magazineCourseService.findCourseByCourseId(courseId);
		course.setDescriptionsList(magazineCourseService.findAllDescriptionForACourse(course));
		
		model.addAttribute("updateList", magazineCourseService.findAllCourseUpdateByCourseIdDescOrder(courseId));
		model.addAttribute("typeMagazine", magazineCourseService.findOneMagazineMagazineId(course.getCourseTypeId()));
		model.addAttribute("courseModel", course);
		model.addAttribute("magazineMenu", "Update");
		model.addAttribute("updateList", magazineCourseService.findAllCourseUpdateByCourseId(courseId));
		model.addAttribute("magazinesubMenu", "");
		return "theMagazineUpdatePage";
	}
	
	@RequestMapping("/pagelist")
	public String magazinePageList(Model model, @PathVariable Long courseId, @PathVariable String courseName){
		Course course = magazineCourseService.findCourseByCourseId(courseId);
		/*course.setDescriptionsList(magazineCourseService.findAllDescriptionForACourse(course));*/
		
		/*model.addAttribute("updateList", magazineCourseService.findAllCourseUpdateByCourseId(courseId));*/
		Magazine magazine = magazineCourseService.findOneMagazineMagazineId(course.getCourseTypeId());
		model.addAttribute("typeMagazine", magazine );
		model.addAttribute("courseModel", course);
		model.addAttribute("magazineMenu", "Page");
		model.addAttribute("magazinesubMenu", "list");
		model.addAttribute("magazinePageList", magazineCourseService.findMagazinePageList(magazine));
		return "theMagazinePageList";
	}
	
	@RequestMapping("/page/{pageId}")
	public String magazinePage(Model model,
			@PathVariable Long courseId, @PathVariable String courseName, 
			@PathVariable Long pageId){
		Course course = magazineCourseService.findCourseByCourseId(courseId);
		/*course.setDescriptionsList(magazineCourseService.findAllDescriptionForACourse(course));*/
		
		/*model.addAttribute("updateList", magazineCourseService.findAllCourseUpdateByCourseId(courseId));*/
		model.addAttribute("typeMagazine", magazineCourseService.findOneMagazineMagazineId(course.getCourseTypeId()));
		model.addAttribute("courseModel", course);
		model.addAttribute("magazineMenu", "Page");
		model.addAttribute("magazinesubMenu", "page");
		
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		
		List<MagazinePageDevelopment> pageDevelopmentList= magazineCourseService.findPageDevelopmentList(magazinePage);
		model.addAttribute("pageDevelopmentList",pageDevelopmentList);
		return "theMagazinePage";
	}
	
	@RequestMapping("/quiz/{pageId}")
	public String magazineQuiz(Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId){
		Course course = magazineCourseService.findCourseByCourseId(courseId);
		/*course.setDescriptionsList(magazineCourseService.findAllDescriptionForACourse(course))*/;
		
		/*model.addAttribute("updateList", magazineCourseService.findAllCourseUpdateByCourseId(courseId));*/
		model.addAttribute("typeMagazine", magazineCourseService.findOneMagazineMagazineId(course.getCourseTypeId()));
		model.addAttribute("courseModel", course);
		model.addAttribute("magazineMenu", "Page");
		model.addAttribute("magazinesubMenu", "quiz");
		
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		
		model.addAttribute("pageQuesList", magazineCourseService.findAllQuesOrderByQuesOrderNo(pageId));
		model.addAttribute("magPageQuizData", new QuizDataModel());
		return "theMagazinePageQuiz";
	}
	
	@RequestMapping(value="/quiz/{pageId}", method=RequestMethod.POST)
	public String magazineQuizResult(@ModelAttribute QuizDataModel magPageQuizData, BindingResult bindingResult,
			Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId){
		Course course = magazineCourseService.findCourseByCourseId(courseId);
		course.setDescriptionsList(magazineCourseService.findAllDescriptionForACourse(course));
		/*System.out.println(magPageQuizData);*/
		model.addAttribute("typeMagazine", magazineCourseService.findOneMagazineMagazineId(course.getCourseTypeId()));
		model.addAttribute("courseModel", course);
		model.addAttribute("magazineMenu", "Page");
		model.addAttribute("magazinesubMenu", "quiz");
		
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		
		List<MagazineQuizQues> quesAnsList = magazineCourseService.findAllQuesOrderByQuesOrderNo(pageId);
		quizResult(magPageQuizData, model, quesAnsList);
		return "theMagazinePageQuizResult";
	}

	private void quizResult(QuizDataModel magPageQuizData, Model model,
			List<MagazineQuizQues> quesAnsList) {
		List<Integer> ans =ansList(magPageQuizData, quesAnsList.size());
		List<MagazineQuizQues> result = new ArrayList<MagazineQuizQues>();
		int i = 0;
		int correctAns = 0;
		int inCorrectAns = 0;
		int dontKnowAns = 0;
		for ( MagazineQuizQues qq : quesAnsList){
			if (ans.get(i) == 5){
				qq.setResult("Dont Know");
				dontKnowAns++;
			} else if (ans.get(i) == qq.getAnswer()) {
				qq.setResult("Correct");
				correctAns++;
			} else {
				qq.setResult("InCorrect");
				inCorrectAns++;
			}
			i++;
			result.add(qq);
		}
		model.addAttribute("pageQuesList", result);
		model.addAttribute("resultString", "No Of Correct Ans = "+correctAns+" , Incorrect Ans= "+inCorrectAns+", Dont Know = "+dontKnowAns);
	}
	
	public List<Integer> ansList(QuizDataModel dataModel, int size){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(dataModel.ansNo(i));
		}
		return list;
	}
	
	

}
