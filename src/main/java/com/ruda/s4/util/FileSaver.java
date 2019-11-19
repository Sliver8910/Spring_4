package com.ruda.s4.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	//3. Io Stream 사용
	public String save3(String realPath, MultipartFile multipartFile)throws Exception{
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
	
	
	
	
	//2. MultipartFile transferTo메서드 사용
	public String save2(String realPath, MultipartFile multipartFile)throws Exception{
		File file = new File(realPath);
		// 없으면 디렉토리 생성
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//저장할 파일명 랜덤으로 바꿔서 파일 중복 방지
		String fileName = UUID.randomUUID().toString();
		fileName = fileName +"_"+multipartFile.getOriginalFilename(); //랜덤 파일에 오리지널 파일을 붙여서 확장자랑 같이 붙여버림
		file = new File(realPath, fileName);
		
		multipartFile.transferTo(file);
		
		return fileName;
	}
	

	// 1. Spring 에서 제공하는 FileCopyUtils 클래스의 Copy 메서드 사용
	public String save (String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);   
		if(!file.exists()) {
			file.mkdirs();

		}
		
		Calendar ca = Calendar.getInstance();
		Long name = ca.getTimeInMillis();//현재시간을 ms로 바꿈, 같은 파일 중복을 방지하기 위해서 이름을 현재시간으로지정
		
		//String ext = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);    //원래 subString을 사용해서 확장자를 꺼내는 방법
		String ext = FilenameUtils.getExtension(multipartFile.getOriginalFilename()); // org.apache.commons.io.FilenameUtils 의 getExtension() 메서드를 사용해서 확장자를 꺼내는 방법
		String fileName = String.valueOf(name)+"."+ext;
		
		file = new File(realPath, fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}
}

