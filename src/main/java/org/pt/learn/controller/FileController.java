package org.pt.learn.controller;

import java.io.IOException;

import org.pt.learn.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ("/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping ("/image/{name}")
	@ResponseBody
	public byte[] getImage(@PathVariable String name) throws IOException {
		return fileService.readImageFile(name.replace("QueuedThreadPoolutil", "."));
	}

}
