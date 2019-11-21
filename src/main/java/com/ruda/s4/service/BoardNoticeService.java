package com.ruda.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ruda.s4.dao.BoardNoticeDAO;
import com.ruda.s4.dao.NoticeFilesDAO;
import com.ruda.s4.model.BoardNoticeVO;
import com.ruda.s4.model.BoardVO;
import com.ruda.s4.model.NoticeFilesVO;
import com.ruda.s4.util.FileSaver;
import com.ruda.s4.util.Pager;
@Service	
public class BoardNoticeService implements BoardService{
	@Inject
	private BoardNoticeDAO boardNoticeDAO;

	@Inject
	private FileSaver fileSaver;  //FileSaver에 가서 component 어노테이션 선언
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	public NoticeFilesVO fileSelect(NoticeFilesVO noticeFilesVO)throws Exception{
		return noticeFilesDAO.fileSelect(noticeFilesVO);
	}
	
	public int fileDelete(NoticeFilesVO noticeFilesVO) throws Exception{
		return noticeFilesDAO.fileDelete(noticeFilesVO);
	}

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		//boardVO = boardNoticeDAO.boardSelect(boardVO);
		//BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		//List<NoticeFilesVO> ar = noticeFilesDAO.fileList(boardVO.getNum());
		
		//boardNoticeVO.setFiles(ar);
		
		//return boardNoticeVO;
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session, MultipartFile [] file) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();

		int result = boardNoticeDAO.boardWrite(boardVO);
		noticeFilesVO.setNum(boardVO.getNum());
		System.out.println(boardVO.getNum());

		for(MultipartFile multipartFile:file){ //향상된 for문으로 file이라는 이름의 배열에서 MultipartFile을 꺼내옴
			if(multipartFile.getSize()!=0) {
			String fileName = fileSaver.save(realPath, multipartFile); // fname
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(multipartFile.getOriginalFilename());
			noticeFilesDAO.fileWrite(noticeFilesVO); }
		}

		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO,  MultipartFile [] file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		
		int result = boardNoticeDAO.boardUpdate(boardVO);
		noticeFilesVO.setNum(boardVO.getNum());
		
		for(MultipartFile multipartFile:file) {
			String fileName = fileSaver.save(realPath, multipartFile);
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(multipartFile.getOriginalFilename());
			noticeFilesDAO.fileWrite(noticeFilesVO);
			
		}
		
		return result;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
