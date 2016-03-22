package org.pt.learn.repositories;

import org.pt.learn.entity.Student;
import org.pt.learn.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	
	Student findByUsers(Users users);
	
}
