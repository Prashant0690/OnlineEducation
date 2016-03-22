package org.pt.learn.service;

import org.pt.learn.entity.TestEntity;
import org.pt.learn.repositories.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

 @Autowired	
 private TestRepo repo;
 
 public void saveAndUpdate (TestEntity entity){
	 repo.save(entity);
 }
 
 public TestEntity get(Long id){
	 return repo.getOne(id);
 }

}
