package com.bstek.ureport.build.paging;

import java.util.List;

import com.bstek.ureport.model.Report;

/**
 * @author Jacky.gao
 * @since 2017年1月17日
 */
public interface Pagination {
	List<Page> doPaging(Report report);
}
