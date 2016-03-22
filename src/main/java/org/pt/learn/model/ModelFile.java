package org.pt.learn.model;

import org.springframework.web.multipart.MultipartFile;

public class ModelFile {
	
	MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}		
}
