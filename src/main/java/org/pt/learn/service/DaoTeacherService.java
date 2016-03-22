package org.pt.learn.service;

import org.pt.learn.entity.GResume;
import org.pt.learn.entity.GResumeInfo;
import org.pt.learn.entity.GResumeSkills;
import org.pt.learn.entity.Teacher;
import org.pt.learn.entity.Users;
import org.pt.learn.repositories.GResumeRepo;
import org.pt.learn.repositories.TeacherRepo;
import org.pt.learn.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoTeacherService {

	@Autowired
	private TeacherRepo teacherRepo;
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private GResumeRepo gResumeRepo;
	
	public Teacher findTeachersDetailsUsingUserName(String userName){
		Users users = usersRepo.findByUserName(userName);
		return teacherRepo.findByUsers(users);
	}

	public Teacher teacherFindByUserEntity(Users users) {
		return teacherRepo.findByUsers(users);
	}
	
	public void saveAndUpdateTeacherDetails(Teacher teacher, String userName) {
		Users user=usersRepo.findByUserName(userName);
		Teacher teacher2 = teacherRepo.findByUsers(user);
		// SAVE AND UPDATE
		teacher2.setTeacherUID( teacher.getTeacherUID() );
		teacher2.setTeachersPresentWork( teacher.getTeachersPresentWork() );
		teacher2.setTeacherDOB( teacher.getTeacherDOB() );
		teacher2.setTeacherSex( teacher.getTeacherSex() );
		teacher2.setTeacherCurrentAddress( teacher.getTeacherCurrentAddress() );
		teacher2.setTeacherPermanentAddress( teacher.getTeacherPermanentAddress() );
		teacher2.setTeacherEmail( teacher.getTeacherEmail() );
		teacher2.setTeacherPhoneNo( teacher.getTeacherPhoneNo() );
		
		if (teacher2.getIsTeacherAuthenticate() == null){
			teacher2.setIsTeacherAuthenticate(false);
		}
		teacherRepo.save(teacher2);
	}

	public GResume findGResume(Long id) {
		return gResumeRepo.findOne(id);
	}

	public void updateGResume(GResume gResumeData, String userName) {
		GResume gResumeUpdate = gResumeRepo.findByResumeUserId("T"+userName);
		gResumeUpdate.setYourName( gResumeData.getYourName() );
		gResumeUpdate.setAboutMe( gResumeData.getAboutMe() );
		gResumeUpdate.setAboutEducation( gResumeData.getAboutEducation() );
		gResumeUpdate.setAboutWork( gResumeData.getAboutWork() );
		gResumeUpdate.setAboutSkills( gResumeData.getAboutSkills() );
		gResumeUpdate.setFamousQuote( gResumeData.getFamousQuote() );
		gResumeUpdate.setQuoteBy( gResumeData.getQuoteBy() );
		gResumeUpdate.setContactMe( gResumeData.getContactMe() );
		gResumeRepo.save(gResumeUpdate);
	}

	public void saveGResume(GResume gResumeData, String userName) {
		gResumeData.setResumeUserId("T"+userName);
		gResumeRepo.save(gResumeData);
	}

	public GResume findResumeByUser(String userName) {
		return gResumeRepo.findByResumeUserId("T"+userName);
	}

	public void saveResumeInfo(GResumeInfo gResumeInfoData, String userName) {
		GResume gResumeUpdate = gResumeRepo.findByResumeUserId("T"+userName);
		gResumeInfoData.setGeneralResume(gResumeUpdate);
		gResumeUpdate.getResumeInfoList().add(gResumeInfoData);
		gResumeRepo.save(gResumeUpdate);
	}

	public void saveResumeSkills(GResumeSkills gResumeSkillsData, String userName) {
		GResume gResumeUpdate = gResumeRepo.findByResumeUserId("T"+userName);
		gResumeSkillsData.setGeneralResume(gResumeUpdate);
		gResumeUpdate.getResumeSkillList().add(gResumeSkillsData);
		gResumeRepo.save(gResumeUpdate);
		
	}

	
}
