// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.test.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mmc.boot.system.mmcab.dao.EodFileRecordMapper;
import com.mmc.boot.system.mmcab.test.BaseTest;

/** 
 * className: EodFileRecordMapperTest<br/>
 * Description: eodFileRecordMapper测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class EodFileRecordMapperTest extends BaseTest{

	@Autowired
	private EodFileRecordMapper eodFileRecordMapper;
	
	private Map<String, Object> paramMap;
	
	@Before
	public void setUp() {
		paramMap = new HashMap<String, Object>();
		paramMap.put("busiDate", "201070114");
		paramMap.put("busiStatus", 0);
		paramMap.put("beginDate", new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR, 2);
		paramMap.put("endDate", calendar.getTime());
	}
	
	@Test
	public void testSave() {
		eodFileRecordMapper.saveEodFile(paramMap);
	}
}
