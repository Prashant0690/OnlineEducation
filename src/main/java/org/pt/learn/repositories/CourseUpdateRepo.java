package org.pt.learn.repositories;

import java.util.List;

import org.pt.learn.entity.CourseUpdates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseUpdateRepo extends JpaRepository<CourseUpdates, Long> {
	
	List<CourseUpdates> findByCourseId(Long courseId);
	
	List<CourseUpdates> findByCourseIdOrderByUpdateDateAsc(Long courseId);

	List<CourseUpdates> findByCourseIdOrderByUpdateIdDesc(Long courseId);
}
