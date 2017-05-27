package com.bstek.ureport.export;

import java.util.List;

import com.bstek.ureport.build.paging.Page;

/**
 * @author Jacky.gao
 * @since 2017年3月23日
 */
public class FullPageData {
	private int totalPages;
	private int columnMargin;
	private List<List<Page>> pageList;
	
	public FullPageData(int totalPages, int columnMargin,List<List<Page>> pageList) {
		this.totalPages = totalPages;
		this.columnMargin = columnMargin;
		this.pageList = pageList;
	}
	public int getColumnMargin() {
		return columnMargin;
	}
	public List<List<Page>> getPageList() {
		return pageList;
	}
	public int getTotalPages() {
		return totalPages;
	}
}
