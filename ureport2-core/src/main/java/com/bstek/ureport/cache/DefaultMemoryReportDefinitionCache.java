package com.bstek.ureport.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.bstek.ureport.definition.ReportDefinition;

/**
 * @author Jacky.gao
 * @since 2016年12月4日
 */
public class DefaultMemoryReportDefinitionCache implements ReportDefinitionCache {
	private Map<String,ReportDefinition> reportMap=new ConcurrentHashMap<String,ReportDefinition>();
	@Override
	public ReportDefinition getReportDefinition(String file) {
		return reportMap.get(file);
	}
	@Override
	public void cacheReportDefinition(String file,ReportDefinition reportDefinition) {
		reportMap.put(file, reportDefinition);
	}
}
