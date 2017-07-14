// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.test.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mmc.boot.system.mmcab.test.BaseTest;

/** 
 * className: DataSourceTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月13日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DataSourceTest extends BaseTest{

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test01() {
		logger.debug("debyg test");
	}
	
	@Test
	public void test() throws SQLException {
		logger.info("datasource: {}", dataSource.getConnection());
	}
}
