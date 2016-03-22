package org.pt.learn.service;

import java.util.Date;
import java.util.List;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.Magazine;
import org.pt.learn.entity.Teacher;
import org.pt.learn.entity.Users;
import org.pt.learn.repositories.CourseRepo;
import org.pt.learn.repositories.MagazineRepo;
import org.pt.learn.repositories.TeacherRepo;
import org.pt.learn.repositories.UsersRepo;
import org.pt.learn.utils.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseDevelopmentService {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired 
	private UsersRepo usersRepo;
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	@Autowired
	private MagazineRepo magazineRepo;
	
	
	/******COURSE******/
	
	// New course Added by a teacher table update are Course, Teacher & Teacher_course
	public void addNewCourse(Course course, String teacherName) {
		Users users = usersRepo.findByUserName(teacherName);
		Teacher teacher = teacherRepo.findByUsers(users);
		List<Course> list = teacher.getCoursesTeacher();
		course.setCourseRegDate(new Date());
		course.setCourseVerified(false);
		list.add(course);
		if (course.getCourseType().equalsIgnoreCase(Snippet.LIST_COURSE_TYPE.get(0))){
			Magazine magazine = new Magazine();
			Magazine magazineSaved = magazineRepo.save(magazine);
			course.setCourseTypeId(magazineSaved.getMagazineId());
		}
		courseRepo.save(course);
		teacher.setCoursesTeacher(list);
		teacherRepo.save(teacher);
	}
	
	public Course updateCourse(Course course,Long courseId){
		Course updateCourse = courseRepo.findOne(courseId);
		updateCourse.setCourseUID(course.getCourseUID());
		updateCourse.setCourseName(course.getCourseName());
		updateCourse.setCourseShortDiscription(course.getCourseShortDiscription());
		updateCourse.setCourseStartDate(course.getCourseStartDate());
		updateCourse.setCourseEndDate(course.getCourseEndDate());
		updateCourse.setCourseSubject(course.getCourseSubject());
		/*updateCourse.setCourseType(course.getCourseType());*/
		updateCourse.setCourseCategory(course.getCourseCategory());
		return courseRepo.save(updateCourse);
	}

	public Course findOneCourse(Long courseId) {
		
		return courseRepo.findOne(courseId);
	}

}
