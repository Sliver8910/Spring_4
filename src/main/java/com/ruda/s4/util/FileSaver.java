package com.ruda.s4.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public String save(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		String fileName = UUID.randomUUID().toString();
		fileName = fileName +"_"+multipartFile.getOriginalFilename();
		file = new File(realPath, fileName);
		
		//연결
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		
		return fileName;
	}

}
