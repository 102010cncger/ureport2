package com.bstek.ureport.cache;

import com.bstek.ureport.model.Report;

/**
 * @author Jacky.gao
 * @since 2017年3月8日
 */
public interface ReportCache {
	Report getReport(String file);
	void storeReport(String file,Report report);
}
