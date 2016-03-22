package org.pt.learn.service;

import java.util.Date;
import java.util.List;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.Teacher;
import org.pt.learn.entity.Users;
import org.pt.learn.repositories.CourseRepo;
import org.pt.learn.repositories.TeacherRepo;
import org.pt.learn.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoCourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	public void addNewCourse(Course course, String teacherName) {
		
		Users users = usersRepo.findByUserName(teacherName);
		Teacher teacher = teacherRepo.findByUsers(users);
		List<Course> list = teacher.getCoursesTeacher();
		course.setCourseRegDate(new Date());
		course.setCourseVerified(false);
		list.add(course);
		courseRepo.save(course);
		teacher.setCoursesTeacher(list);
		teacherRepo.save(teacher);
	}
	
}
