package org.pt.learn.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.pt.learn.entity.CourseDescription;
import org.pt.learn.entity.CourseUpdates;
import org.pt.learn.entity.MagPageParagraph;
import org.pt.learn.entity.MagPagePicURL;
import org.pt.learn.entity.Magazine;
import org.pt.learn.entity.MagazinePage;
import org.pt.learn.entity.MagazinePageDevelopment;
import org.pt.learn.entity.MagazineQuizQues;
import org.pt.learn.model.ModelFile;
import org.pt.learn.service.FileService;
import org.pt.learn.service.MagazineCourseService;
import org.pt.learn.utils.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping ("/course/development/{courseId}/{courseName}/TheMagazineCourse")
public class CourseDevelopmentMagazine {
	
	@ModelAttribute ("modelFileData")
	public ModelFile constructModelFile(){
		return new ModelFile();
	}
	
	@ModelAttribute ("courseDescriptionData")
	public CourseDescription constructCourseDescription(){
		return new CourseDescription();
	}
	
	@ModelAttribute ("magazineData")
	public Magazine constructMagazine(){
		return new Magazine();
	}
	
	@ModelAttribute ("magazinePageData")
	public MagazinePage constructMagazinePage(){
		return new MagazinePage();
	}
	
	@ModelAttribute ("magazineParagraphData")
	public MagPageParagraph constructMagPageParagraph(){
		return new MagPageParagraph();
	}
	
	@ModelAttribute ("madazinePicUrlData")
	public MagPagePicURL constructMagPagePicURL(){
		return new MagPagePicURL();
	}
	
	@ModelAttribute ("magazineQuizQuesData")
	public MagazineQuizQues constructQuizQues(){
		return new MagazineQuizQues();
	}
	
	@ModelAttribute ("courseUpdateData")
	public CourseUpdates constructCourseUpdates(){
		return new CourseUpdates();
	}
	
	@Autowired
	private MagazineCourseService magazineCourseService;
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping (method=RequestMethod.GET)
	public String demo(Model model, @PathVariable Long courseId, @PathVariable String courseName ){
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		return "devMagazineHome";
	}
	
	@RequestMapping ("/update")
	public String courseUpdatePage(Model model, @PathVariable Long courseId,
			@PathVariable String courseName){
		model.addAttribute("current", "courseUpdate");
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		model.addAttribute("showForm", false);
		model.addAttribute("updateList", magazineCourseService.findAllCourseUpdateByCourseId(courseId));
		return "commCourseUpdate";
	}
	
	@RequestMapping ("/update/{updateId}")
	public String courseUpdateAdd(Model model, @PathVariable Long courseId,
			@PathVariable String courseName, @PathVariable String updateId ){
		model.addAttribute("current", "courseUpdate");
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		model.addAttribute("showForm", true);
		model.addAttribute("updateList", magazineCourseService.findAllCourseUpdateByCourseId(courseId));
		try {
			Long id = Long.parseLong(updateId);
			model.addAttribute("courseUpdateData", magazineCourseService.findOneCourseUpdate(id));
		} catch (Exception e) {
			
		}
		return "commCourseUpdate";
	}
	
	@RequestMapping (value="/update/{updateId}", method=RequestMethod.POST)
	public String courseUpdateSaveUpdate(@Valid @ModelAttribute("courseUpdateData") CourseUpdates courseUpdateData,
			BindingResult bindingResult,Model model, @PathVariable Long courseId,
			@PathVariable String courseName, @PathVariable String updateId ){
	
		magazineCourseService.saveUpdateCourseUpdateTable(courseUpdateData, courseId, updateId);
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/update.html";
	}
	
	@RequestMapping ("/update/{updateId}/post")
	public String courseUpdatePost(Model model, @PathVariable Long courseId,
			@PathVariable String courseName, @PathVariable String updateId ){
		magazineCourseService.changeDoUpdateOfCourseUpdate(Long.parseLong(updateId), courseId);
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/update.html";
	}
	
	@RequestMapping ("/update/{updateId}/remove")
	public String courseUpdateRemove(Model model, @PathVariable Long courseId,
			@PathVariable String courseName, @PathVariable String updateId ){
		magazineCourseService.deleteCourseUpdate(Long.parseLong(updateId));
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/update.html";
	}
	
	@RequestMapping("/description")
	public String descriptionPage(Model model, @PathVariable Long courseId, @PathVariable String courseName){
		model.addAttribute("current", "description");
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		model.addAttribute("typeId", 0);
		model.addAttribute("descriptionModel", magazineCourseService.findAllDescriptionForACourse(courseId) );
		return "devMagazineCourseDescriptionPage";
	}
	
	@RequestMapping("/{no}/description")
	public String addUpdateDescription(Model model, @PathVariable Long courseId,
			@PathVariable String courseName , @PathVariable int no ){
			model.addAttribute("current", "description");
			model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
			model.addAttribute("typeId", String.valueOf(no));
			model.addAttribute("descriptionModel", magazineCourseService.findAllDescriptionForACourse(courseId) );
			CourseDescription courseDescription = magazineCourseService.descFindByCourseIdAndDescNo(courseId,no);
			model.addAttribute("courseDescriptionData", courseDescription);
		return "devMagazineCourseDescriptionPage";
	}
	
	@RequestMapping(value="/{no}/description", method=RequestMethod.POST)
	public String addUpdateDescriptionSave(@Valid @ModelAttribute("courseDescriptionData") CourseDescription courseDescriptionData ,
			BindingResult bindingResult,
			Model model, @PathVariable Long courseId,
			@PathVariable String courseName , @PathVariable int no ){
		magazineCourseService.saveDescByCourseIdAndDescNo(courseId, no, courseDescriptionData);
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/description.html";
	}
	
	@RequestMapping("/coverPage")
	public String magazineCover(Model model, @PathVariable Long courseId, @PathVariable String courseName){
		model.addAttribute("current", "cover");
		model.addAttribute("showForm", false);
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		model.addAttribute("magazineModel", magazineCourseService.findOneMagazine(courseId));
		// model.addAttribute("descriptionModel", magazineCourseService.findAllDescriptionForACourse(courseId) );
		return "devMagazineCoverPage";
	}
	
	@RequestMapping("/coverPage/form")
	public String magazineCoverForm(Model model, @PathVariable Long courseId, @PathVariable String courseName){
		model.addAttribute("current", "cover");
		model.addAttribute("showForm", true);
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		model.addAttribute("magazineModel", magazineCourseService.findOneMagazine(courseId));
		model.addAttribute("schedualOptions", Snippet.MAGAZINE_SCHEDUAL_LIST);
		// model.addAttribute("descriptionModel", magazineCourseService.findAllDescriptionForACourse(courseId) );
		return "devMagazineCoverPage";
	}
	
	@RequestMapping(value="/coverPage/form", method=RequestMethod.POST)
	public String magazineCoverFormSave(@Valid @ModelAttribute("magazineData") Magazine magazine,
			BindingResult bindingResult,
			Model model, @PathVariable Long courseId, @PathVariable String courseName){
			/*Magazine savedMagazine =*/ magazineCourseService.saveMagazine(courseId, magazine);
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/coverPage";
	}
	
	@RequestMapping("/coverPage/image/{magazineId}")
	public String magazineImageUpload(Model model, @PathVariable Long courseId, @PathVariable String courseName
			,@PathVariable Long magazineId){
		model.addAttribute("current", "cover");
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		model.addAttribute("magazineModel", magazineCourseService.findOneMagazine(courseId));
		String s ="/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/upload/"+magazineId;
		model.addAttribute("imageAction", s);
		return "imagesUpload";
	}
	
	/*@RequestMapping(value="/coverPage/form/{magazineId}", method=RequestMethod.POST)
	public String magazineImageUploadSave(@Valid @ModelAttribute ("modelFileData") ModelFile modelFile,
			Model model, @PathVariable Long courseId, @PathVariable String courseName
			, @PathVariable Long magazineId){
		System.out.println("success");
			
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/coverPage";
	}*/
	
	@RequestMapping(value="/upload/{magazineId}", method=RequestMethod.POST)
    public  String handleFileUpload(  @PathVariable Long courseId,
    		@PathVariable String courseName, @PathVariable Long magazineId ,
    		@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
            	String imageName = fileService.saveMultipartFile(file, String.valueOf(new Date().getTime()));
            	magazineCourseService.UpdateMagazineImage(courseId, imageName);
            } catch (Exception e) {
            }
        } else {
        }
        return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/coverPage";
    }
	
	@RequestMapping("/page")
	public String magazinePage(Model model, @PathVariable Long courseId, @PathVariable String courseName){
		model.addAttribute("current", "page");
		model.addAttribute("showForm", false);
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		Magazine magazine = magazineCourseService.findOneMagazine(courseId);
		model.addAttribute("magazineModel", magazine );
		model.addAttribute("magazinePageList", magazineCourseService.findMagazinePageList(magazine));
		// model.addAttribute("descriptionModel", magazineCourseService.findAllDescriptionForACourse(courseId) );
		return "devMagazinePage";
	}
	
	@RequestMapping("/page/form/{status}/{pageId}")
	public String magazinePageForm(Model model, @PathVariable Long courseId, @PathVariable String courseName,
			@PathVariable String status, @PathVariable Long pageId){
		model.addAttribute("current", "page");
		model.addAttribute("showForm", true);
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		Magazine magazine = magazineCourseService.findOneMagazine(courseId);
		model.addAttribute("magazineModel", magazine );
		model.addAttribute("magazinePageList", magazineCourseService.findMagazinePageList(magazine));
		MagazinePage magazinePage;
		if("new".equalsIgnoreCase(status)){
			magazinePage = new MagazinePage();
			List<MagazinePage> pagesList = magazineCourseService.findMagazinePageList(magazine);
			magazinePage.setPageNo(pagesList.size()+1);
		} else {
			magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		}
		
		model.addAttribute("magazinePageData", magazinePage);
		return "devMagazinePage";
	}
	
	@RequestMapping(value="/page/form/{status}/{pageId}", method=RequestMethod.POST)
	public String magazinePageFormSave(@Valid @ModelAttribute("magazinePageData") MagazinePage magazinePage,
			BindingResult bindingResult,
			Model model, @PathVariable Long courseId, @PathVariable String courseName,
			@PathVariable String status, @PathVariable Long pageId){
		
		if("NEW".equalsIgnoreCase(status)){
			magazineCourseService.saveMagazinePage(magazinePage, courseId);
		} else {
			magazineCourseService.updateMagazinePage(magazinePage, pageId);
		}
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/page";
	}
	
	@RequestMapping(value="/page/form/update/{pageId}", method=RequestMethod.POST)
	public String magazinePageFormSave2Update(@Valid @ModelAttribute("magazinePageData") MagazinePage magazinePage,
			BindingResult bindingResult,
			Model model, @PathVariable Long courseId, @PathVariable String courseName,
			@PathVariable String pageId){
		
		
			magazineCourseService.updateMagazinePage(magazinePage, Long.parseLong(pageId));
		
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/page";
	}
	
	
	@RequestMapping("/page/form/design/develop/{pageId}")
	public String pageDesignAndDevelopment(Model model, @PathVariable Long courseId, @PathVariable String courseName,
			 @PathVariable Long pageId){
		model.addAttribute("current", "page");
		model.addAttribute("showForm", "false");
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		Magazine magazine = magazineCourseService.findOneMagazine(courseId);
		model.addAttribute("magazineModel", magazine );
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		List<MagazinePageDevelopment> pageDevelopmentList= magazineCourseService.findPageDevelopmentList(pageId);
		model.addAttribute("pageDevelopmentList",pageDevelopmentList);
		return "devMagazinePageDesign";
	}
	
	@RequestMapping("/page/form/design/develop/{pageId}/para/{newUpdate}/{head}/{tail}/{currentId}")
	public String addParagraphToPage(Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable String newUpdate,
			@PathVariable String head, @PathVariable String tail,
			@PathVariable String currentId ){
		
		model.addAttribute("current", "page");
		model.addAttribute("showForm", "paraForm");
			if ("UPDATE".equalsIgnoreCase(newUpdate)){
				MagPageParagraph paragraph = magazineCourseService.findOneMagazineParagraph(Long.parseLong(currentId));
				model.addAttribute("magazineParagraphData", paragraph);
			} else {
				model.addAttribute("magazineParagraphData", new MagPageParagraph() );
			}
		
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		Magazine magazine = magazineCourseService.findOneMagazine(courseId);
		model.addAttribute("magazineModel", magazine );
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		List<MagazinePageDevelopment> pageDevelopmentList= magazineCourseService.findPageDevelopmentList(pageId);
		model.addAttribute("pageDevelopmentList",pageDevelopmentList);
		return "devMagazinePageDesign";
	}
	
	@RequestMapping(value="/page/form/design/develop/{pageId}/para/{newUpdate}/{head}/{tail}/{currentId}", method=RequestMethod.POST)
	public String addParagraphToPageSave(@Valid @ModelAttribute("magazineParagraphData") MagPageParagraph magazineParagraphData,
			BindingResult bindingResult, Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable String newUpdate,
			@PathVariable String head, @PathVariable String tail,
			@PathVariable String currentId ){
		
		System.out.println();
		if("UPDATE".equalsIgnoreCase(newUpdate)){
			magazineCourseService.updateMagazineParagraph(magazineParagraphData, Long.parseLong(currentId));
		}else{
			magazineCourseService.saveNewMagazineParagraph(magazineParagraphData, head, tail, pageId,currentId);
		}
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/page/form/design/develop/"+pageId+".html";
	}
	
	@RequestMapping("/page/form/design/develop/{pageId}/pic/{newUpdate}/{head}/{tail}/{currentId}")
	public String addImageToPage(Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable String newUpdate,
			@PathVariable String head, @PathVariable String tail,
			@PathVariable String currentId ){
		
		model.addAttribute("current", "page");
		/*model.addAttribute("showForm", "imageForm");*/
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		Magazine magazine = magazineCourseService.findOneMagazine(courseId);
		model.addAttribute("magazineModel", magazine );
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		List<MagazinePageDevelopment> pageDevelopmentList= magazineCourseService.findPageDevelopmentList(pageId);
		model.addAttribute("pageDevelopmentList",pageDevelopmentList);
		String s ="/course/development/"+courseId+"/"
				  +courseName+"/TheMagazineCourse/page/form/design/develop/"
				  +pageId+"/pic/"+newUpdate+"/"+head+"/"+tail+"/"+currentId+"/upload";
		model.addAttribute("imageAction", s);
		return "imagesUpload";
	}
	
	@RequestMapping(value="/page/form/design/develop/{pageId}/pic/{newUpdate}/{head}/{tail}/{currentId}/upload", method=RequestMethod.POST)
	public String addImageToPageSave(Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable String newUpdate,
			@PathVariable String head, @PathVariable String tail,
			@PathVariable String currentId,
			@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
		if (!file.isEmpty()) {
            try {
            	String imageName = fileService.saveMultipartFile(file, String.valueOf(new Date().getTime()));
            	if("UPDATE".equalsIgnoreCase(newUpdate)){
            		
            	}else{
            		MagPagePicURL pagePicURL = new MagPagePicURL();
            		pagePicURL.setPicUrl(imageName);
            		if(name != null){
            			pagePicURL.setPicName(name);
            		}
            		magazineCourseService.saveNewMagazineImage(pagePicURL, head, tail, pageId,currentId);
            	}
            } catch (Exception e) {
            	e.printStackTrace();
            }
        } else {
        }
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/page/form/design/develop/"+pageId+".html";
	}
	
	@RequestMapping("/page/form/design/develop/{pageId}/remove/{currentId}")
	public String removeImageParagraph(@PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable Long currentId ){
		
		magazineCourseService.removeMagazinePageDevId(currentId, pageId);
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/page/form/design/develop/"+pageId+".html";
	}
	
	
	
	
	
	
	
	@RequestMapping("/add/questions/{pageId}")
	public String questionsPage(Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId){
		model.addAttribute("showForm", "dontShow");
		model.addAttribute("current", "page");
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		Magazine magazine = magazineCourseService.findOneMagazine(courseId);
		model.addAttribute("magazineModel", magazine );
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		/*List<MagazinePageDevelopment> pageDevelopmentList= magazineCourseService.findPageDevelopmentList(pageId);*/
		/*model.addAttribute("pageDevelopmentList",pageDevelopmentList);*/
		model.addAttribute("pageQuesList", magazineCourseService.findAllQues(pageId));
		
		return "devMagazinePageQuesAns";
	}
	
	@RequestMapping("/add/questions/{pageId}/{addUpdate}/{quizQuesId}")
	public String questionsPageAddUpdate(Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable String addUpdate,@PathVariable String quizQuesId){
		model.addAttribute("showForm", "quesForm");
		model.addAttribute("current", "page");
		model.addAttribute("courseM", magazineCourseService.findCourseByCourseId(courseId));
		Magazine magazine = magazineCourseService.findOneMagazine(courseId);
		model.addAttribute("magazineModel", magazine );
		MagazinePage  magazinePage = magazineCourseService.findOneMagazinePageById(pageId);
		model.addAttribute("magazinePage", magazinePage);
		/*List<MagazinePageDevelopment> pageDevelopmentList= magazineCourseService.findPageDevelopmentList(pageId);*/
		/*model.addAttribute("pageDevelopmentList",pageDevelopmentList);*/
		List<MagazineQuizQues> quizQuesList = magazineCourseService.findAllQues(pageId);
		model.addAttribute("pageQuesList", quizQuesList);
		
		if ("UPDATE".equalsIgnoreCase(addUpdate)){
			model.addAttribute("magazineQuizQuesData", magazineCourseService.findOneMagazineQuizQues(Long.parseLong(quizQuesId)));
		} else {
			MagazineQuizQues ques = new MagazineQuizQues();
			ques.setQuesOrderNo(quizQuesList.size()+1);
			model.addAttribute("magazineQuizQuesData", ques);
		}
		
		model.addAttribute("pageQuizQuesAction", "/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/add/questions/"+pageId+"/"+addUpdate+"/"+quizQuesId);
		return "devMagazinePageQuesAns";
	}
	
	// magazineQuizQuesData
	
	@RequestMapping(value="/add/questions/{pageId}/{addUpdate}/{quizQuesId}", method=RequestMethod.POST)
	public String questionsPageAddUpdateSave(@Valid @ModelAttribute("magazineQuizQuesData") MagazineQuizQues magazineQuizQuesData,
			BindingResult bindingResult, Model model,
			@PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable String addUpdate,@PathVariable String quizQuesId){
		
		if ("add".equalsIgnoreCase(addUpdate)){
			magazineCourseService.addUpdateMagazineQuizQues( magazineQuizQuesData, pageId,addUpdate, quizQuesId);
		} else {
			magazineCourseService.addUpdateMagazineQuizQues( magazineQuizQuesData, pageId,addUpdate, quizQuesId);
		}
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/add/questions/"+pageId;
	}
	
	@RequestMapping("/delete/questions/{pageId}/{quizQuesId}")
	public String questionsPagedelete(Model model, @PathVariable Long courseId, 
			@PathVariable String courseName, @PathVariable Long pageId,
			@PathVariable String quizQuesId){
		
		magazineCourseService.deleteQuesWithId(Long.parseLong(quizQuesId));
		return "redirect:/course/development/"+courseId+"/"+courseName+"/TheMagazineCourse/add/questions/"+pageId;
	}
	
	
}
