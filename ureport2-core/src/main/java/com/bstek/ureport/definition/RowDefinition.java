package com.bstek.ureport.definition;

import java.util.List;

import com.bstek.ureport.model.Row;

/**
 * @author Jacky.gao
 * @since 2016年11月1日
 */
public class RowDefinition implements Comparable<RowDefinition>{
	private int rowNumber;
	private int height;
	private Band band;
	protected Row newRow(List<Row> rows){
		Row row=new Row(rows);
		row.setHeight(height);
		row.setBand(band);
		return row;
	}
	
	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
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

	@Override
	public int compareTo(RowDefinition o) {
		return rowNumber-o.getRowNumber();
	}
}
