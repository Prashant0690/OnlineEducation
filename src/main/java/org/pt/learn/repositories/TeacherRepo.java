package org.pt.learn.repositories;

import org.pt.learn.entity.Teacher;
import org.pt.learn.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {

	Teacher findByUsers(Users user);

}
