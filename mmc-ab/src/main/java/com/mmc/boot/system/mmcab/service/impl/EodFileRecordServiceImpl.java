// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mmc.boot.system.mmcab.dao.EodFileRecordMapper;
import com.mmc.boot.system.mmcab.domain.EodFileRecordEntity;
import com.mmc.boot.system.mmcab.service.EodFileRecordService;

/** 
 * className: EodFileRecordServiceImpl<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class EodFileRecordServiceImpl implements EodFileRecordService {

	@Autowired
	private EodFileRecordMapper eodFileRecordMapper;
	
	/* (non-Javadoc)
	 * @see com.mmc.boot.system.mmcab.service.EodFileRecordService#saveEodFileRecord(com.mmc.boot.system.mmcab.domain.EodFileRecordEntity)
	 */
	@Override
	public void saveEodFileRecord(EodFileRecordEntity entity) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("busiDate", entity.getBusiDate());
		paramMap.put("busiStatus", entity.getBusiStatus());
		paramMap.put("beginDate", entity.getBeginDate());
		paramMap.put("endDate", entity.getEndDate());
		eodFileRecordMapper.saveEodFile(paramMap);
	}

}
