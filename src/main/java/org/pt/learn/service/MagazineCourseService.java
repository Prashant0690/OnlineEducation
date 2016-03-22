package org.pt.learn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.CourseDescription;
import org.pt.learn.entity.CourseUpdates;
import org.pt.learn.entity.MagPageParagraph;
import org.pt.learn.entity.MagPagePicURL;
import org.pt.learn.entity.Magazine;
import org.pt.learn.entity.MagazinePage;
import org.pt.learn.entity.MagazinePageDevelopment;
import org.pt.learn.entity.MagazineQuizQues;
import org.pt.learn.repositories.CourseDescriptionRepo;
import org.pt.learn.repositories.CourseRepo;
import org.pt.learn.repositories.CourseUpdateRepo;
import org.pt.learn.repositories.MagPageParagraphRepo;
import org.pt.learn.repositories.MagPagePicUrlRepo;
import org.pt.learn.repositories.MagazinePageDevelopmentRepo;
import org.pt.learn.repositories.MagazinePageRepo;
import org.pt.learn.repositories.MagazineQuizQuesRepo;
import org.pt.learn.repositories.MagazineRepo;
import org.pt.learn.utils.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MagazineCourseService {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private CourseDescriptionRepo courseDescriptionRepo;
	
	@Autowired
	private MagazineRepo magazineRepo;
	
	@Autowired
	private MagazinePageRepo magazinePageRepo;
	
	@Autowired
	private MagazinePageDevelopmentRepo magazinePageDevelopmentRepo;
	
	@Autowired
	private MagPageParagraphRepo magPageParagraphRepo;
	
	@Autowired
	private MagPagePicUrlRepo magPagePicUrlRepo;
	
	@Autowired
	private MagazineQuizQuesRepo magazineQuizQuesRepo;
	
	@Autowired
	private CourseUpdateRepo courseUpdateRepo;
	
	public List<CourseUpdates> findAllCourseUpdateByCourseId(Long courseId){
		List<CourseUpdates> list = courseUpdateRepo.findByCourseId(courseId);
		return list;
	}
	
	public List<CourseUpdates> findAllCourseUpdateByCourseIdDescOrder(Long courseId){
		/*List<CourseUpdates> list = courseUpdateRepo.findByCourseId(courseId);*/
		/*List<CourseUpdates> list = courseUpdateRepo.findByCourseIdOrderByUpdateDateAsc(courseId);*/
		List<CourseUpdates> list = courseUpdateRepo.findByCourseIdOrderByUpdateIdDesc(courseId);
		return list;
	}
	
	public CourseUpdates findOneCourseUpdate(Long updateId){
		return courseUpdateRepo.findOne(updateId);
	}
	
	public void deleteCourseUpdate(Long updateId){
		courseUpdateRepo.delete(updateId);
	}
	
	public void changeDoUpdateOfCourseUpdate(Long updateId, Long courseId){
		CourseUpdates courseUpdates = courseUpdateRepo.findOne(updateId);
		Course course = courseRepo.findOne(courseId);
		if (courseUpdates.getDoUpdate()){
			courseUpdates.setDoUpdate(false);
		} else {
			courseUpdates.setDoUpdate(true);
			course.setLatestUpdateId(courseUpdates.getUpdateId());
		}
		courseUpdateRepo.save(courseUpdates);
		courseRepo.save(course);
	}
	
	public void saveUpdateCourseUpdateTable(CourseUpdates courseUpdates, Long courseId, String updateId){
		try {
			Long id = Long.parseLong(updateId);
			CourseUpdates courseUpdates2 = courseUpdateRepo.findOne(id);
			courseUpdates2.setUpdateTitle( courseUpdates.getUpdateTitle() );
			courseUpdates2.setUpdateMessage( courseUpdates.getUpdateMessage() );
			courseUpdateRepo.save(courseUpdates2);
		} catch (Exception e) {
			courseUpdates.setCourseId(courseId);
			courseUpdates.setUpdateDate(new Date());
			courseUpdateRepo.save(courseUpdates);
		}
	}

	public CourseDescription descFindByCourseIdAndDescNo(Long courseId, int no) {
		Course course = courseRepo.findOne(courseId);
		CourseDescription newDescription =courseDescriptionRepo.findByCourseAndDescNo(course, Integer.valueOf(no)) ;
		if (newDescription != null){
			return newDescription;
		} else {
			newDescription = new CourseDescription();
			newDescription.setDescNo(Integer.valueOf(no));
			for(String str :Snippet.COURSE_DESCRIPTION_LIST){
				if( no == Integer.parseInt(str.substring(0, 3))){
					newDescription.setDescType(str);
					break;
				}
			}
			return newDescription;
		}
	} 
	
	public CourseDescription saveDescByCourseIdAndDescNo(Long courseId, int no, CourseDescription description) {
		Course course = courseRepo.findOne(courseId);
		CourseDescription updatedesc = courseDescriptionRepo.findByCourseAndDescNo(course, no) ;
		if(updatedesc != null) {
			
			updatedesc.setDescString(description.getDescString());
			return courseDescriptionRepo.save(updatedesc);
		} else {
			description.setDescNo(no);
			description.setCourse(course);
			return courseDescriptionRepo.save(description);
		}
	}

	public List<CourseDescription> findAllDescriptionForACourse(Long courseId) {
		Course course = courseRepo.findOne(courseId);
		return courseDescriptionRepo.findByCourse(course);
	}
	
	public List<CourseDescription> findAllDescriptionForACourse(Course course) {
		/*Course course = courseRepo.findOne(courseId);*/
		return courseDescriptionRepo.findByCourse(course);
	}

	public Course findCourseByCourseId(Long courseId) {
		// TODO Auto-generated method stub
		return courseRepo.findOne(courseId);
	}
	
	
	public Magazine findOneMagazine(Long courseId){
		Course course = courseRepo.findOne(courseId);
		return magazineRepo.findOne(course.getCourseTypeId());
	}
	
	public Magazine findOneMagazineMagazineId(Long magazineId){
		/*Course course = courseRepo.findOne(courseId);*/
		return magazineRepo.findOne(magazineId);
	}
	
	public Magazine saveMagazine(Long courseId , Magazine magazine){
		Course course = courseRepo.findOne(courseId);
		Magazine updateMagazine = magazineRepo.findOne(course.getCourseTypeId());
		updateMagazine.setTitle(magazine.getTitle());
		updateMagazine.setOpeningQuote(magazine.getOpeningQuote());
		updateMagazine.setScheduled(magazine.getScheduled());
		updateMagazine.setAuthorBio(magazine.getAuthorBio());
		updateMagazine.setDispatchedDate(magazine.getDispatchedDate());
		updateMagazine.setAdviceColumn(magazine.getAdviceColumn());
		return magazineRepo.save(updateMagazine);
	}
	
	public Magazine UpdateMagazineImage(Long courseId, String name){
		Course course = courseRepo.findOne(courseId);
		Magazine updateMagazine = magazineRepo.findOne(course.getCourseTypeId());
		name = name.replace(".", "QueuedThreadPoolutil");
		updateMagazine.setCoverPicUrl(name);
		return magazineRepo.save(updateMagazine);
	}

	public List<MagazinePage> findMagazinePageList(Magazine magazine) {
		return magazinePageRepo.findByMagazine(magazine);
	}

	public MagazinePage findOneMagazinePageById(Long pageId) {
		return magazinePageRepo.findOne(pageId);
	}

	public MagazinePage saveMagazinePage(MagazinePage magazinePage, Long courseId) {
		Course course = courseRepo.findOne(courseId);
		Magazine updateMagazine = magazineRepo.findOne(course.getCourseTypeId());
		magazinePage.setMagazine(updateMagazine);
		return magazinePageRepo.save(magazinePage);
	}
	
	public MagazinePage updateMagazinePage(MagazinePage magazinePage, Long pageId) {
		MagazinePage updateMagazinePage = magazinePageRepo.findOne(pageId);
		updateMagazinePage.setPageTitle( magazinePage.getPageTitle() );
		updateMagazinePage.setPageSubTitle( magazinePage.getPageSubTitle() );
		updateMagazinePage.setPageQuote( magazinePage.getPageQuote() );
		updateMagazinePage.setGoOnlineDate( magazinePage.getGoOnlineDate() );
		updateMagazinePage.setAddQuiz(magazinePage.getAddQuiz());
		
		//magazinePage.setMagazine(updateMagazine);
		return magazinePageRepo.save(updateMagazinePage);
	}

	public List<MagazinePageDevelopment> findPageDevelopmentList(Long pageId) {
		MagazinePage magazinePage = magazinePageRepo.findOne(pageId);
		List<MagazinePageDevelopment> list = new ArrayList<MagazinePageDevelopment>();
		Long id ;
		if (magazinePage.getParaHead() == null){
			return null;
		}else {
			id = magazinePage.getParaHead();
			while (id != null){
				MagazinePageDevelopment development = magazinePageDevelopmentRepo.findOne(id);
				list.add(development);
				id = (development.getNextLink()==null? null : development.getNextLink());
			}
			return list;
		}
	}
	
	public List<MagazinePageDevelopment> findPageDevelopmentList(MagazinePage magazinePage) {
		/*MagazinePage magazinePage = magazinePageRepo.findOne(pageId);*/
		List<MagazinePageDevelopment> list = new ArrayList<MagazinePageDevelopment>();
		Long id ;
		if (magazinePage.getParaHead() == null){
			return null;
		}else {
			id = magazinePage.getParaHead();
			while (id != null){
				MagazinePageDevelopment development = magazinePageDevelopmentRepo.findOne(id);
				list.add(development);
				id = (development.getNextLink()==null? null : development.getNextLink());
			}
			return list;
		}
	}

	public MagPageParagraph findOneMagazineParagraph(Long pageDevelopmentId) {
		MagazinePageDevelopment development = magazinePageDevelopmentRepo.findOne(pageDevelopmentId);
		return development.getMagPageParagraph();
	}

	public void updateMagazineParagraph(MagPageParagraph magazineParagraphData,
			Long pageDevelopmentId) {
		MagazinePageDevelopment development = magazinePageDevelopmentRepo.findOne(pageDevelopmentId);
		MagPageParagraph updatePageParagraph = development.getMagPageParagraph();
		updatePageParagraph.setParaContent(magazineParagraphData.getParaContent());
		magPageParagraphRepo.save(updatePageParagraph);
	}
	
	public void saveNewMagazineParagraph(MagPageParagraph magazineParagraphData,
			String head, String tail, Long pageId, String currentId) {
		MagazinePage magazinePage = magazinePageRepo.findOne(pageId);
		
		if ("HEAD".equalsIgnoreCase(head) && "TAIL".equalsIgnoreCase(tail)){
			addFirstColumn(magazineParagraphData, magazinePage);
		
		} else if ("TAIL".equalsIgnoreCase(tail)){
			MagazinePageDevelopment newMagPageDev = new MagazinePageDevelopment();
			MagazinePageDevelopment currentDev = magazinePageDevelopmentRepo.findOne(Long.parseLong(currentId));
			magazineParagraphData.setDevelopment(newMagPageDev);
			newMagPageDev.setMagPageParagraph(magazineParagraphData);
			newMagPageDev.setMagazinePage(magazinePage);
			newMagPageDev = magazinePageDevelopmentRepo.save(newMagPageDev);
			currentDev.setNextLink(newMagPageDev.getPageDevelopmentId());
			newMagPageDev.setPreviousLink(currentDev.getPageDevelopmentId());
			magazinePageDevelopmentRepo.save(currentDev);
			magazinePageDevelopmentRepo.save(newMagPageDev);
			
		} else {
			MagazinePageDevelopment newMagPageDev = new MagazinePageDevelopment();
			MagazinePageDevelopment currentDev = magazinePageDevelopmentRepo.findOne(Long.parseLong(currentId));
			MagazinePageDevelopment bottomDev = magazinePageDevelopmentRepo.findOne(currentDev.getNextLink());
			magazineParagraphData.setDevelopment(newMagPageDev);
			newMagPageDev.setMagPageParagraph(magazineParagraphData);
			newMagPageDev.setMagazinePage(magazinePage);
			newMagPageDev = magazinePageDevelopmentRepo.save(newMagPageDev);
			currentDev.setNextLink(newMagPageDev.getPageDevelopmentId());
			newMagPageDev.setNextLink(bottomDev.getPageDevelopmentId());
			newMagPageDev.setPreviousLink(currentDev.getPageDevelopmentId());
			bottomDev.setPreviousLink(newMagPageDev.getPageDevelopmentId());
			magazinePageDevelopmentRepo.save(currentDev);
			magazinePageDevelopmentRepo.save(newMagPageDev);
			magazinePageDevelopmentRepo.save(bottomDev);
			
		} 
	}
	
	

	private void addFirstColumn(MagPageParagraph magazineParagraphData,
			MagazinePage magazinePage) 
	{
		/*MagPageParagraph saveMagPagePara ;*/
		MagazinePageDevelopment saveMagPageDev = new MagazinePageDevelopment();
		if (magazinePage.getParaHead() == null ){
			magazineParagraphData.setDevelopment(saveMagPageDev);
			saveMagPageDev.setMagPageParagraph(magazineParagraphData);
			saveMagPageDev.setMagazinePage(magazinePage);
			saveMagPageDev = magazinePageDevelopmentRepo.save(saveMagPageDev);
			magazinePage.setParaHead(saveMagPageDev.getPageDevelopmentId());
			magazinePageRepo.save(magazinePage);
		}else{
			MagazinePageDevelopment oldDevelopment = magazinePageDevelopmentRepo.findOne(magazinePage.getParaHead());
			magazineParagraphData.setDevelopment(saveMagPageDev);
			saveMagPageDev.setMagPageParagraph(magazineParagraphData);
			saveMagPageDev.setMagazinePage(magazinePage);
			saveMagPageDev = magazinePageDevelopmentRepo.save(saveMagPageDev);
			magazinePage.setParaHead(saveMagPageDev.getPageDevelopmentId());
			magazinePageRepo.save(magazinePage);
			
			saveMagPageDev.setNextLink(oldDevelopment.getPageDevelopmentId());
			oldDevelopment.setPreviousLink(saveMagPageDev.getPageDevelopmentId());
			magazinePageDevelopmentRepo.save(saveMagPageDev);
			magazinePageDevelopmentRepo.save(oldDevelopment);
		}
	}

	public void saveNewMagazineImage(MagPagePicURL pagePicURL, String head,
			String tail, Long pageId, String currentId) {
		pagePicURL.setPicUrl(pagePicURL.getPicUrl().replace(".", "QueuedThreadPoolutil"));
		MagazinePage magazinePage = magazinePageRepo.findOne(pageId);
		MagazinePageDevelopment newMagPageDev = new MagazinePageDevelopment();
		
		if ("HEAD".equalsIgnoreCase(head) && "TAIL".equalsIgnoreCase(tail)){
			if (magazinePage.getParaHead() == null ){
				newMagPageDev.setMagPagePicURL(pagePicURL);
				newMagPageDev.setMagazinePage(magazinePage);
				pagePicURL.setDevelopment(newMagPageDev);
				newMagPageDev=magazinePageDevelopmentRepo.save(newMagPageDev);
				magazinePage.setParaHead(newMagPageDev.getPageDevelopmentId());
				magazinePageRepo.save(magazinePage);
			}else{
				MagazinePageDevelopment oldPageDevelopment = magazinePageDevelopmentRepo.findOne(magazinePage.getParaHead());
				newMagPageDev.setMagPagePicURL(pagePicURL);
				newMagPageDev.setMagazinePage(magazinePage);
				pagePicURL.setDevelopment(newMagPageDev);
				newMagPageDev=magazinePageDevelopmentRepo.save(newMagPageDev);
				magazinePage.setParaHead(newMagPageDev.getPageDevelopmentId());
				magazinePageRepo.save(magazinePage);
				
				oldPageDevelopment.setPreviousLink(newMagPageDev.getPageDevelopmentId());
				newMagPageDev.setNextLink(oldPageDevelopment.getPageDevelopmentId());
				magazinePageDevelopmentRepo.save(newMagPageDev);
				magazinePageDevelopmentRepo.save(oldPageDevelopment);
			}
		} else if ("TAIL".equalsIgnoreCase(tail)){
				MagazinePageDevelopment currentDev = magazinePageDevelopmentRepo.findOne(Long.parseLong(currentId));
				pagePicURL.setDevelopment(newMagPageDev);
				newMagPageDev.setMagPagePicURL(pagePicURL);
				newMagPageDev.setMagazinePage(magazinePage);
				newMagPageDev = magazinePageDevelopmentRepo.save(newMagPageDev);
				currentDev.setNextLink(newMagPageDev.getPageDevelopmentId());
				newMagPageDev.setPreviousLink(currentDev.getPageDevelopmentId());
				magazinePageDevelopmentRepo.save(currentDev);
				magazinePageDevelopmentRepo.save(newMagPageDev);
			
		} else {
				MagazinePageDevelopment currentDev = magazinePageDevelopmentRepo.findOne(Long.parseLong(currentId));
				MagazinePageDevelopment bottomDev = magazinePageDevelopmentRepo.findOne(currentDev.getNextLink());
				pagePicURL.setDevelopment(newMagPageDev);
				newMagPageDev.setMagPagePicURL(pagePicURL);
				newMagPageDev.setMagazinePage(magazinePage);
				newMagPageDev = magazinePageDevelopmentRepo.save(newMagPageDev);
				currentDev.setNextLink(newMagPageDev.getPageDevelopmentId());
				newMagPageDev.setNextLink(bottomDev.getPageDevelopmentId());
				newMagPageDev.setPreviousLink(currentDev.getPageDevelopmentId());
				bottomDev.setPreviousLink(newMagPageDev.getPageDevelopmentId());
				magazinePageDevelopmentRepo.save(currentDev);
				magazinePageDevelopmentRepo.save(newMagPageDev);
				magazinePageDevelopmentRepo.save(bottomDev);
		}
		
	}

	public void removeMagazinePageDevId(Long currentId, Long pageId) {
		MagazinePage magazinePage = magazinePageRepo.findOne(pageId);
		MagazinePageDevelopment removeDev = magazinePageDevelopmentRepo.findOne(currentId);
		if (removeDev.getPreviousLink()!= null && removeDev.getNextLink() != null ){
			MagazinePageDevelopment previousDev = magazinePageDevelopmentRepo.findOne(removeDev.getPreviousLink());
			MagazinePageDevelopment nextDev = magazinePageDevelopmentRepo.findOne(removeDev.getNextLink());
			previousDev.setNextLink( nextDev.getPageDevelopmentId() );
			nextDev.setPreviousLink(previousDev.getPageDevelopmentId());
			magazinePageDevelopmentRepo.save(previousDev);
			magazinePageDevelopmentRepo.save(nextDev);
			magazinePageDevelopmentRepo.delete(currentId);
			
		} else if (magazinePage.getParaHead() == currentId){
			MagazinePageDevelopment nextDev = magazinePageDevelopmentRepo.findOne(removeDev.getNextLink());
			magazinePage.setParaHead(nextDev.getPageDevelopmentId());
			nextDev.setPreviousLink(null);
			magazinePageRepo.save(magazinePage);
			magazinePageDevelopmentRepo.save(nextDev);
			magazinePageDevelopmentRepo.delete(currentId);
			
		} else {
			MagazinePageDevelopment previousDev = magazinePageDevelopmentRepo.findOne(removeDev.getPreviousLink());
			previousDev.setNextLink(null);
			magazinePageDevelopmentRepo.save(previousDev);
			magazinePageDevelopmentRepo.delete(currentId);
		}
	}

	public List<MagazineQuizQues> findAllQues(Long pageId) {
		
		return magazineQuizQuesRepo.findByCourseTypeId(Snippet.LIST_COURSE_TYPE.get(0)+pageId+"PAGE");
	}
	
	public List<MagazineQuizQues> findAllQuesOrderByQuesOrderNo(Long pageId) {
		
		//return magazineQuizQuesRepo.findByCourseTypeId(Snippet.LIST_COURSE_TYPE.get(0)+pageId+"PAGE");
		return magazineQuizQuesRepo.findByCourseTypeIdOrderByQuesOrderNo(Snippet.LIST_COURSE_TYPE.get(0)+pageId+"PAGE");
	}

	public MagazineQuizQues findOneMagazineQuizQues(long quizQuesId) {
		// TODO Auto-generated method stub
		return magazineQuizQuesRepo.findOne(quizQuesId);
	}

	public void addUpdateMagazineQuizQues(
			MagazineQuizQues magazineQuizQuesData,Long pageId,
			String addUpdate, String quizQuesId) {
		if("add".equalsIgnoreCase(addUpdate)){
			magazineQuizQuesData.setCourseTypeId(Snippet.LIST_COURSE_TYPE.get(0)+pageId+"PAGE");
			magazineQuizQuesRepo.save(magazineQuizQuesData);
		} else {
			MagazineQuizQues updateQuizQues = magazineQuizQuesRepo.findOne(Long.parseLong(quizQuesId));
			updateQuizQues.setQuestion( magazineQuizQuesData.getQuestion() );
			updateQuizQues.setOption1( magazineQuizQuesData.getOption1() );
			updateQuizQues.setOption2( magazineQuizQuesData.getOption2() );
			updateQuizQues.setOption3( magazineQuizQuesData.getOption3());
			updateQuizQues.setOption4( magazineQuizQuesData.getOption4() );
			updateQuizQues.setAnswer( magazineQuizQuesData.getAnswer() );
			updateQuizQues.setAnsDescription( magazineQuizQuesData.getAnsDescription() );
			magazineQuizQuesRepo.save(updateQuizQues);
		}
	}

	public void deleteQuesWithId(long quizQuesId) {
		magazineQuizQuesRepo.delete(quizQuesId);
	}

	

}
