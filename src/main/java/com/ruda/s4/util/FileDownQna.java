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

import com.ruda.s4.model.QnaFilesVO;

@Component
public class FileDownQna extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		QnaFilesVO qnaFilesVO = (QnaFilesVO)model.get("file");
		String board = (String)model.get("board");
		
		String realPath = request.getSession().getServletContext().getRealPath("resources/upload/"+board);
		
		File file = new File(realPath, qnaFilesVO.getFname());
		
		response.setCharacterEncoding("UTF-8");
		
		response.setContentLength((int)file.length());
		
		String fileName = URLEncoder.encode(qnaFilesVO.getOname(),"UTF-8");
		
		response.setHeader("Content-disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
	}

}
