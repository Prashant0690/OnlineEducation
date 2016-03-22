package org.pt.learn.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class FileService {
	
	String fileName = null;
	
	public String saveMultipartFile(MultipartFile file , String uniqueName) throws IOException{
		
		String contentType = file.getContentType();
		fileName = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
        BufferedOutputStream buffStream = 
                new BufferedOutputStream(new FileOutputStream(new File("C:/Users/prashant/Pictures/Images/"+uniqueName+fileName)));
        buffStream.write(bytes);
        buffStream.close();
		return uniqueName+fileName;
	}
	
	public byte[] readImageFile(String uniqueName) throws IOException{
		String stringPath = "C:/Users/prashant/Pictures/Images/" + uniqueName;
		
		Path path = Paths.get(stringPath);
		byte[] data = Files.readAllBytes(path); 
		return data;
	}
	
	
	
	public void cloudinaryUpload(MultipartFile file) throws IOException{
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "ddoor1kgg",
				  "api_key", "728117347696793",
				  "api_secret", "Pc73eeYYw4Tgn_TLvj1C7QtlcNE"));
		
		
		//CLOUDINARY_URL=cloudinary://728117347696793:Pc73eeYYw4Tgn_TLvj1C7QtlcNE@ddoor1kgg;
		
		//File fileToUpload = new File(file.getContentType());
		Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		System.out.println(uploadResult.get("url"));
		
	}
	
	

}
