package com.ruda.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;

public class DataSourceTest extends TestAbstractCase{

	@Inject
	private DataSource datasource;	
	
	@Test
	public void  dataSourcetest() throws Exception{
		assertNotNull(datasource.getConnection());
	}

}
