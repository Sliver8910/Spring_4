package com.ruda.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ruda.s4.dao.BoardQnaDAO;
import com.ruda.s4.dao.QnaFilesDAO;
import com.ruda.s4.model.BoardQnaVO;
import com.ruda.s4.model.BoardVO;
import com.ruda.s4.model.QnaFilesVO;
import com.ruda.s4.util.FileSaver;
import com.ruda.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService{
	@Inject
	private BoardQnaDAO boardQnaDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private QnaFilesDAO qnaFilesDAO;

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		//boardVO = boardQnaDAO.boardSelect(boardVO);
		//BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO;
		//List<QnaFilesVO> ar = qnaFilesDAO.fileList(boardVO.getNum());
		
		//boardQnaVO.setFiles(ar);
		//return boardQnaVO;
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session, MultipartFile [] file) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		
		int result = boardQnaDAO.boardWrite(boardVO);
		qnaFilesVO.setNum(boardVO.getNum());
		
		for(MultipartFile multipartFile:file) {
			String fileName = fileSaver.save(realPath, multipartFile);
			qnaFilesVO.setFname(fileName);
			qnaFilesVO.setOname(multipartFile.getOriginalFilename());
			qnaFilesDAO.fileWrite(qnaFilesVO);
			
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardDelete(boardVO);
	}
	
	public int boardReply(BoardVO boardVO)throws Exception{
		boardQnaDAO.boardReplyUpdate(boardVO);
		
		int result = boardQnaDAO.boardReply(boardVO);
		return result;
	}
	

}
