package com.bstek.ureport.cache;

import java.util.Collection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.bstek.ureport.model.Report;

/**
 * @author Jacky.gao
 * @since 2017年3月8日
 */
public class CacheUtils implements ApplicationContextAware{
	private static ReportCache reportCache;
	
	public static Report getReport(String file){
		if(reportCache!=null){
			return reportCache.getReport(file);
		}
		return null;
	}
	public static void storeReport(String file,Report report){
		if(reportCache!=null){
			reportCache.storeReport(file, report);
		}
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		Collection<ReportCache> coll=applicationContext.getBeansOfType(ReportCache.class).values();
		if(coll.size()>0){
			reportCache=coll.iterator().next();
		}
	}
}
