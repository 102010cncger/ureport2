package com.bstek.ureport.model;

import java.util.List;

import com.bstek.ureport.definition.CellStyle;
import com.bstek.ureport.definition.Expand;
import com.bstek.ureport.definition.value.Value;

/**
 * @author Jacky.gao
 * @since 2017年1月19日
 */
public interface ReportCell {
	CellStyle getCellStyle();
	String getName();
	int getRowSpan();
	int getColSpan();
	Row getRow();
	Column getColumn();
	Object getData();
	Value getValue();
	Expand getExpand();
	List<Object> getBindData();
}