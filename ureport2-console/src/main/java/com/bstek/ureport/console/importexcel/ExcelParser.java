package com.bstek.ureport.console.importexcel;

import java.io.InputStream;

import com.bstek.ureport.definition.ReportDefinition;

/**
 * @author Jacky.gao
 * @since 2017年5月27日
 */
public abstract class ExcelParser {
	public abstract ReportDefinition parse(InputStream inputStream) throws Exception;
	public abstract boolean support(String name);
}
