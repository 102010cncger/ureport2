package com.bstek.ureport.build.paging;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.definition.Paper;
import com.bstek.ureport.model.Report;
import com.bstek.ureport.model.Row;

/**
 * @author Jacky.gao
 * @since 2017年1月17日
 */
public class FixRowsPagination extends BasePagination implements Pagination {
	@Override
	public List<Page> doPaging(Report report) {
		Paper paper=report.getPaper();
		int fixRows=paper.getFixRows();
		List<Row> rows=report.getRows();
		List<Row> headerRows=report.getHeaderRepeatRows();
		List<Row> footerRows=report.getFooterRepeatRows();
		List<Page> pages=new ArrayList<Page>();
		List<Row> pageRows=new ArrayList<Row>();
		int pageIndex=1;
		for(Row row:rows){
			int height=row.getRealHeight();
			if(height<1){
				continue;
			}
			pageRows.add(row);
			if((pageRows.size()+footerRows.size()) >= fixRows){
				pageRows.addAll(footerRows);
				Page newPage=buildPage(pageRows,headerRows,footerRows,pageIndex,report);
				pageIndex++;
				pages.add(newPage);
				pageRows=new ArrayList<Row>();
			}
		}
		if(pageRows.size()>headerRows.size()){
			pageRows.addAll(footerRows);
			Page newPage=buildPage(pageRows,headerRows,footerRows,pageIndex,report);
			pageIndex++;
			pages.add(newPage);
		}
		buildPageHeaderFooter(pages, report);
		return pages;
	}
}
