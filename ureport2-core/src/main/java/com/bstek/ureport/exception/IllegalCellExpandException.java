package com.bstek.ureport.exception;

import com.bstek.ureport.model.ReportCell;

/**
 * @author Jacky.gao
 * @since 2016年11月1日
 */
public class IllegalCellExpandException extends ReportException{
	private static final long serialVersionUID = -2442986317129037490L;

	public IllegalCellExpandException(ReportCell cell) {
		super("Cell expand is "+cell.getExpand()+" is invalid.");
	}
}
