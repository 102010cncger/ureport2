package com.bstek.ureport.definition;

import java.util.List;

import com.bstek.ureport.model.Column;

/**
 * @author Jacky.gao
 * @since 2016年11月1日
 */
public class ColumnDefinition implements Comparable<ColumnDefinition>{
	private int columnNumber;
	private int width;
	private boolean hide;
	
	protected Column newColumn(List<Column> columns){
		Column col=new Column(columns);
		col.setHide(hide);
		col.setWidth(width);
		return col;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	@Override
	public int compareTo(ColumnDefinition o) {
		return columnNumber-o.getColumnNumber();
	}
}
