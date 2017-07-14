// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.test.logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmc.boot.system.mmcab.test.BaseTest;

/** 
 * className: LoggerTest<br/>
 * Description: 日志测试类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月13日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LoggerTest extends BaseTest{

	// logger
	private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	
	@Test
	public void testInfo() {
		logger.info("test logger info....");
	}
	
	@Test
	public void testDebug() {
		logger.debug("test logger debug....");
	}
	
	@Test
	public void testError() {
		logger.error("test logger error....");
	}
}
