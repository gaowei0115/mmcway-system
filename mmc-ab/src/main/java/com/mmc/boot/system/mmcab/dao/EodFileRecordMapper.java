// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.dao;

import java.util.Map;

/** 
 * className: EodFileRecordMapper<br/>
 * Description: eod文件处理mapper<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public interface EodFileRecordMapper {

	/**
	 * Description：保存Eod文件信息<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param eodFileRecordEntity
	 */
	public void saveEodFile(Map<String, Object> paramMap);
}
