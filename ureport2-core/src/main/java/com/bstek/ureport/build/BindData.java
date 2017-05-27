package com.bstek.ureport.build;

import java.util.List;


/**
 * @author Jacky.gao
 * @since 2016年11月1日
 */
public class BindData {
	private Object value;
	private List<Object> dataList;
	public BindData(Object value) {
		this.value=value;
	}
	public BindData(Object value,List<Object> dataList) {
		this.value=value;
		this.dataList=dataList;
	}
	public Object getValue() {
		return value;
	}
	public List<Object> getDataList() {
		return dataList;
	}
}
