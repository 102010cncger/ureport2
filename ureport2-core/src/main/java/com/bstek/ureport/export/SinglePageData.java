package com.bstek.ureport.export;

import java.util.List;

import com.bstek.ureport.build.paging.Page;

/**
 * @author Jacky.gao
 * @since 2017年3月23日
 */
public class SinglePageData {
	private int totalPages;
	private int pageIndex;
	private List<Page> pages;
	private int columnMargin;
	
	public SinglePageData(int totalPages, int columnMargin,List<Page> pages) {
		this.totalPages = totalPages;
		this.columnMargin=columnMargin;
		this.pages = pages;
	}
	public SinglePageData(int totalPages, int pageIndex, int columnMargin,List<Page> pages) {
		this.totalPages = totalPages;
		this.pageIndex = pageIndex;
		this.columnMargin=columnMargin;
		this.pages = pages;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public List<Page> getPages() {
		return pages;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getColumnMargin() {
		return columnMargin;
	}
}
