package com.ruda.s4.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ruda.s4.model.MemberVO;
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memberMapper.";

	@Override
	public MemberVO memberCheckId(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"memberCheckId", memberVO);
	}
	
	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "memberJoin", memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO);
	}


	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"memberUpdate", memberVO);
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int MemberPointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
