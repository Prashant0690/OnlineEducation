package org.pt.learn.repositories;

import java.util.List;

import org.pt.learn.entity.Course;
import org.pt.learn.entity.CourseDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDescriptionRepo extends JpaRepository<CourseDescription, Long> {
	
	List<CourseDescription> findByCourse(Course course);
	
	CourseDescription findByCourseAndDescNo(Course course, Integer descNo);
}
