package org.pt.learn.service;

import java.util.Date;

import org.pt.learn.entity.Student;
import org.pt.learn.entity.Users;
import org.pt.learn.repositories.StudentRepo;
import org.pt.learn.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoStudentService {
	
	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private MailService mailService;
	
	public void saveStudent(Users users) {
		
		users.setUserType("ROLE_STUDENT");
		users.setDateCreater(new Date());
		Student student = new Student();
		student.setUsers(users);
		usersRepo.save(users);
		studentRepo.save(student);
		mailService.sendMail("clam.prashant@gmail.com", users.getUserEmail(), "VERICATION", "http://localhost:8080/student/"+users.getUserName()+"verify.html");
		/*mailService.sendMail("clam.prashant@gmail.com", users.getUserEmail(), "WELCOME", "Please use the Below link to activete ur account");*/
		
	}
	
}
