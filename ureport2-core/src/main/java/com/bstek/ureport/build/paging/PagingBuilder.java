package com.bstek.ureport.build.paging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bstek.ureport.definition.PagingMode;
import com.bstek.ureport.definition.Paper;
import com.bstek.ureport.model.Report;

/**
 * @author Jacky.gao
 * @since 2017年1月17日
 */
public class PagingBuilder {
	private static Map<PagingMode,Pagination> paginationMap=new HashMap<PagingMode,Pagination>();
	static{
		paginationMap.put(PagingMode.fitpage, new FitPagePagination());
		paginationMap.put(PagingMode.fixrows, new FixRowsPagination());
	}
	public static List<Page> buildPages(Report report){
		Paper paper = report.getPaper();
		Pagination pagination=paginationMap.get(paper.getPagingMode());
		List<Page> pages=pagination.doPaging(report);
		return pages;
	}
}
