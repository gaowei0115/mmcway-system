// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mmc.boot.system.mmcab.server.Application;

/** 
 * className: BaseTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月13日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)
@WebAppConfiguration  
public abstract class BaseTest {

	// logger
	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
}
