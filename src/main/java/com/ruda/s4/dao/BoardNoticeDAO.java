package com.ruda.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ruda.s4.model.BoardVO;
import com.ruda.s4.util.Pager;
@Repository
public class BoardNoticeDAO implements BoardDAO{//인터페이스를 구현(상속 받을때 implements 사용)
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper.";
	

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"boardList", pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardSelect", boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"boardUpdate", boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"boardDelete", boardVO);
	}

	@Override
	public int boardCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardCount", pager);
	} 

}
