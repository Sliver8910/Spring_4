package com.ruda.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ruda.s4.TestAbstractCase;
import com.ruda.s4.model.MemberVO;

public class MemberDAOImplTest extends TestAbstractCase{
	
	@Inject
	private SqlSession sqlsession;

	//@Test
	public void memberJoinTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("n1");
		memberVO.setId("id1");
		memberVO.setPw("pw1");
		memberVO.setGender("M");
		memberVO.setEmail("e1@g.com");
		memberVO.setBirth("2019-11-15");
		int result = sqlsession.insert("memberMapper.memberJoin", memberVO);
		assertEquals(1, result);
	}
	
	@Test
	public void memberLoginTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id3");
		memberVO.setPw("pw3");
		MemberVO memberVO2 = sqlsession.selectOne("memberMapper.memberLogin", memberVO);
		
		assertNotNull(memberVO2);
	}

}
