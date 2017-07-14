// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * className: Application<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月13日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
@SpringBootApplication(scanBasePackages="com.mmc.boot.system.mmcab")
public class Application {

	/**
	 * Description：启动入口<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
