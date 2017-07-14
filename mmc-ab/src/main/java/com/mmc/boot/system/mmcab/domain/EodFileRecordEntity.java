// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.domain;

import java.io.Serializable;
import java.util.Date;

/** 
 * className: EodFileRecord<br/>
 * Description: eod文件处理实体<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class EodFileRecordEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2172149217047152850L;
	
	private Integer id;
	
	private String busiDate;
	
	private int busiStatus;
	
	private Date beginDate;
	
	private Date endDate;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the busiDate
	 */
	public String getBusiDate() {
		return busiDate;
	}

	/**
	 * @param busiDate the busiDate to set
	 */
	public void setBusiDate(String busiDate) {
		this.busiDate = busiDate;
	}

	/**
	 * @return the busiStatus
	 */
	public int getBusiStatus() {
		return busiStatus;
	}

	/**
	 * @param busiStatus the busiStatus to set
	 */
	public void setBusiStatus(int busiStatus) {
		this.busiStatus = busiStatus;
	}

	/**
	 * @return the beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
