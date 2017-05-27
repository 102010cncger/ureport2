package com.bstek.ureport.console.designer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bstek.ureport.definition.CellDefinition;
import com.bstek.ureport.definition.ColumnDefinition;
import com.bstek.ureport.definition.HeaderFooterDefinition;
import com.bstek.ureport.definition.Paper;
import com.bstek.ureport.definition.ReportDefinition;
import com.bstek.ureport.definition.RowDefinition;
import com.bstek.ureport.definition.datasource.DatasourceDefinition;

/**
 * @author Jacky.gao
 * @since 2017年1月29日
 */
public class ReportDefinitionWrapper {
	private Paper paper;
	private HeaderFooterDefinition header;
	private HeaderFooterDefinition footer;
	private List<RowDefinition> rows;
	private List<ColumnDefinition> columns;
	private List<DatasourceDefinition> datasources;
	private Map<String,CellDefinition> cellsMap=new HashMap<String,CellDefinition>();
	public ReportDefinitionWrapper(ReportDefinition report) {
		this.paper=report.getPaper();
		this.header=report.getHeader();
		this.footer=report.getFooter();
		this.rows=report.getRows();
		this.columns=report.getColumns();
		this.datasources=report.getDatasources();
		for(CellDefinition cell:report.getCells()){
			cellsMap.put(cell.getRowNumber()+","+cell.getColumnNumber(), cell);
		}
	}
	public List<ColumnDefinition> getColumns() {
		return columns;
	}
	public List<DatasourceDefinition> getDatasources() {
		return datasources;
	}
	public HeaderFooterDefinition getFooter() {
		return footer;
	}
	public HeaderFooterDefinition getHeader() {
		return header;
	}
	public Paper getPaper() {
		return paper;
	}
	public Map<String, CellDefinition> getCellsMap() {
		return cellsMap;
	}
	public List<RowDefinition> getRows() {
		return rows;
	}
}
