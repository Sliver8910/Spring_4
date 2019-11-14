package com.ruda.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ruda.s4.TestAbstractCase;
import com.ruda.s4.model.BoardVO;

public class NoticeDAOTest extends TestAbstractCase {

	@Inject
	private SqlSession sqlsession;
	
	@Test
	public void noticeSelectTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(152);
		 boardVO = sqlsession.selectOne("noticeMapper.boardSelect", boardVO);
		 System.out.println(boardVO.getNum());
		 assertNotNull(boardVO);
	}

}
