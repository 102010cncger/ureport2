package com.bstek.ureport.model;

import java.util.List;

import com.bstek.ureport.definition.Band;


/**
 * @author Jacky.gao
 * @since 2016年11月1日
 */
public class Row extends Line{
	private int height;
	private int realHeight=-1;
	
	/**
	 * 一个用来临时存放当前行号的属性，只在构建报表时创建新行时使用
	 */
	private int tempRowNumber;
	private Band band;
	private boolean forPaging;
	private List<Row> rows;
	
	public Row(List<Row> rows) {
		this.rows=rows;
	}
	
	public Row newRow(){
		Row row=new Row(rows);
		row.setHeight(height);
		row.setRealHeight(realHeight);
		return row;
	}
	
	public int getRowNumber() {
		return rows.indexOf(this)+1;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Band getBand() {
		return band;
	}
	public void setBand(Band band) {
		this.band = band;
	}

	public boolean isForPaging() {
		return forPaging;
	}

	public void setForPaging(boolean forPaging) {
		this.forPaging = forPaging;
	}

	public int getTempRowNumber() {
		return tempRowNumber;
	}

	public void setTempRowNumber(int tempRowNumber) {
		this.tempRowNumber = tempRowNumber;
	}

	public int getRealHeight() {
		if(realHeight==-1){
			return height;
		}
		return realHeight;
	}

	public void setRealHeight(int realHeight) {
		this.realHeight = realHeight;
	}
}
