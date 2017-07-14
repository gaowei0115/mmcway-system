// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.test.dao;

import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.mmc.boot.system.mmcab.test.BaseTest;

/** 
 * className: SqlSessionFactoryBeanTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月13日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SqlSessionFactoryBeanTest extends BaseTest {

	@Autowired
	private SqlSessionFactoryBean sessionFactoryBean;
	
	@Test
	public void test() {
		logger.info("sqlSessionFactoryBean {}", sessionFactoryBean);
	}
}
