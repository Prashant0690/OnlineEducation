package org.pt.learn.controller;


import org.pt.learn.entity.TestEntity;
import org.pt.learn.service.FileService;
import org.pt.learn.service.MailService;
import org.pt.learn.service.TestService;
import org.pt.learn.service.UploadVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class TestController {
	
	@ModelAttribute ("testEntity")
	public TestEntity testEntity(){
		return new TestEntity();
	}
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private UploadVideo upload;
	
	@Autowired
	private MailService mail;
	
	@Autowired
	private FileService imageService;
	
	@RequestMapping ("/test")
	public String test(){
		/*upload.mainUploadFunction();*/
		return "test";
	}
	
	@RequestMapping (value="/test/add" , method=RequestMethod.POST)
	public String doAdd(Model model,@ModelAttribute("testEntity") TestEntity testEntity,
			BindingResult result ,
			@RequestParam(value = "image", required = false) MultipartFile image){
		try {
			
			imageService.cloudinaryUpload(image);
			
		imageService.saveMultipartFile(image, "hello");
		/*String fileName = null;
		System.out.println(testEntity);
		testService.saveAndUpdate(testEntity);
		fileName = image.getOriginalFilename();
		testEntity.setUrl("src/main/resources/"+fileName);
		byte[] bytes = image.getBytes();
        BufferedOutputStream buffStream = 
                new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/"+fileName)));
        buffStream.write(bytes);
        buffStream.close();
        model.addAttribute("url", "../resources/"+fileName);*/
        
        
		}
		catch (Exception e){
			e.printStackTrace();
		}
		/*mail.sendMail("clam.prashant@gmail.com", "prshnttiwari16@gmail.com", "HelloSir", "Welcome");
		
		testService.saveAndUpdate(testEntity);*/
		
		return "test";
	}

}
