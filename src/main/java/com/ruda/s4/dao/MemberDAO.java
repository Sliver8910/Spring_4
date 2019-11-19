package com.ruda.s4.dao;

import com.ruda.s4.model.MemberVO;

public interface MemberDAO {
	
	//idCheck
	public MemberVO memberCheckId(MemberVO memberVO)throws Exception;
	
	//join
	public int memberJoin(MemberVO memberVO)throws Exception;
	
	//login
	public MemberVO memberLogin(MemberVO memberVO)throws Exception;
	
	//update
	public int memberUpdate(MemberVO memberVO) throws Exception;
	//delete
	public int memberDelete(MemberVO memberVO)throws Exception;
	//point update
	public int MemberPointUpdate(MemberVO memberVO)throws Exception;

}
