package com.ruda.s4.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ruda.s4.dao.BoardQnaDAO;
import com.ruda.s4.model.BoardQnaVO;
import com.ruda.s4.model.BoardVO;
import com.ruda.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService{
	@Inject
	private BoardQnaDAO boardQnaDAO;

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardWrite(boardVO);
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
