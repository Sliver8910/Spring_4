package com.ruda.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SessionTest extends TestAbstractCase{

	@Inject
	private SqlSession sqlsession;
	
	@Test
	public void test() {
		assertNotNull(sqlsession);
	}

}
