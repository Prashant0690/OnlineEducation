package org.pt.learn.controller;

import org.pt.learn.model.TestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ("/app/blog/learn")
public class BlogController {
	
	@RequestMapping("/")
	public String blogPage(){
		
		return "angularBlog";
	}
	
	@RequestMapping (value="/test", method=RequestMethod.GET)
	public ResponseEntity<?> test(){
		TestModel model = new TestModel();
		model.setName("Prashant");model.setAge(18);model.setNumber(34);model.setSchool("CCC");
		model.setOnlineShopping("flipkart");
		return new ResponseEntity<TestModel>(model, HttpStatus.ACCEPTED);
	}
	

}
