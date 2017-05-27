package com.bstek.ureport.console.exception;

import com.bstek.ureport.exception.ReportException;

/**
 * @author Jacky.gao
 * @since 2017年1月26日
 */
public class ReportDesignException extends ReportException {
	private static final long serialVersionUID = 4046240733455821337L;
	public ReportDesignException(Exception ex) {
		super(ex);
	}
	public ReportDesignException(String msg) {
		super(msg);
	}
}
