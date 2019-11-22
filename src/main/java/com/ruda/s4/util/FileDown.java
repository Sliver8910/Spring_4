package com.ruda.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.ruda.s4.model.FilesVO;

@Component
public class FileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FilesVO filesVO = (FilesVO)model.get("file");
		String board = (String)model.get("board");
		
		String realPath = request.getSession().getServletContext().getRealPath("resources/upload/"+board);
		System.out.println(realPath);
		
		File file = new File(realPath, filesVO.getFname());
		
		//한글처리
		response.setCharacterEncoding("UTF-8");
		
		//파일의 크기
		response.setContentLength((int)file.length());
		
		//다운로드시 파일 이름 인코딩
		String fileName = URLEncoder.encode(filesVO.getOname(),"UTF-8");
		
		//header 설정
		response.setHeader("Content-disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		//outputStream    Stream은 연결까지만 해줌
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
	}
	

}
