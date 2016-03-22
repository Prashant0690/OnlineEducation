package org.pt.learn.service;

import java.util.List;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.CourseDescription;
import org.pt.learn.entity.CourseUpdates;
import org.pt.learn.entity.Magazine;
import org.pt.learn.entity.Student;
import org.pt.learn.entity.Teacher;
import org.pt.learn.entity.Users;
import org.pt.learn.repositories.CourseDescriptionRepo;
import org.pt.learn.repositories.CourseRepo;
import org.pt.learn.repositories.CourseUpdateRepo;
import org.pt.learn.repositories.MagazineRepo;
import org.pt.learn.repositories.StudentRepo;
import org.pt.learn.repositories.UsersRepo;
import org.pt.learn.utils.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationCommonService {
	
	@Autowired
	private DaoUsersService daoUsersService;
	
	@Autowired
	private DaoTeacherService daoTeacherService;
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired 
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseDescriptionRepo courseDescriptionRepo;
	
	@Autowired
	private MagazineRepo magazineRepo;
	
	@Autowired
	private CourseUpdateRepo courseUpdateRepo;
	
	public Users findUserUsingUserName(String userName){
		return daoUsersService.userFindByUserName(userName);
	}
	
	/*STUDENT*/
	public Student findOneStudentByUserName(String name) {
		Users users = usersRepo.findByUserName(name);
		return studentRepo.findByUsers(users);
	}
	
	
	/*TEACHER*/
	// find Teacher detaild using UserName
	public Teacher findTeachersDetailsUsingUserName(String userName){
		Users users = daoUsersService.userFindByUserName(userName);
		return daoTeacherService.teacherFindByUserEntity(users);
	}
	
	/*COURSE*/
	public List<Course> findAllCourse(){
		return courseRepo.findAll();
	}
	
	public Course findOneCourse(Long courseId){
		return courseRepo.findOne(courseId);
	}

	public List<CourseDescription> findAllDescriptionForGivenCourseId(Long courseId) {
		Course course = courseRepo.findOne(courseId);
		return courseDescriptionRepo.findByCourse(course);
	}
	
	public List<CourseDescription> findAllDescriptionForGivenCourseId(Course course) {
		return courseDescriptionRepo.findByCourse(course);
	}

	public void joinCourseStudent(Long courseId, String name) {
		Users users = usersRepo.findByUserName(name);
		Student student = studentRepo.findByUsers(users);
		Course course = courseRepo.findOne(courseId);
		student.getCoursesStudent().add(course);
		studentRepo.save(student);
		
	}

	public Magazine findCourseTypeModelMagazine(Long courseTypeId) {
		
		return magazineRepo.findOne(courseTypeId);
	}

	public CourseUpdates latestUpdate(Long latestUpdateId) {
		// TODO Auto-generated method stub
		return courseUpdateRepo.findOne(latestUpdateId);
	}

	

}
