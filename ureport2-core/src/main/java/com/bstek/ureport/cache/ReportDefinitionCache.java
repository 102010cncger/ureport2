package com.bstek.ureport.cache;

import com.bstek.ureport.definition.ReportDefinition;

/**
 * @author Jacky.gao
 * @since 2016年12月4日
 */
public interface ReportDefinitionCache {
	ReportDefinition getReportDefinition(String file);
	void cacheReportDefinition(String file,ReportDefinition reportDefinition);
}
