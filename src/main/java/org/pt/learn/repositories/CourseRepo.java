package org.pt.learn.repositories;

import org.pt.learn.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
