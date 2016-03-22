package org.pt.learn.service;

import org.pt.learn.entity.Users;
import org.pt.learn.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoUsersService {

	@Autowired
	private UsersRepo usersRepo;

	public Users userFindByUserName(String userName) {
		return usersRepo.findByUserName(userName);
	}
	
}
