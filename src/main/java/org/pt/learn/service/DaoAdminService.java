package org.pt.learn.service;

import org.pt.learn.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoAdminService {

	@Autowired
	private AdminRepo adminRepo;
	
}
