package com.bstek.ureport.provider.report;

import java.util.Date;

/**
 * @author Jacky.gao
 * @since 2017年2月11日
 */
public class ReportFile {
	private String name;
	private Date updateDate;
	
	public ReportFile(String name, Date updateDate) {
		this.name = name;
		this.updateDate = updateDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
