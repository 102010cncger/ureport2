package com.bstek.ureport;

import java.util.Map;

import com.bstek.ureport.model.ReportCell;

/**
 * @author Jacky.gao
 * @since 2017年1月19日
 */
public interface CellRenderer {
	Object doRender(ReportCell cell,Map<String,Object> parameters);
}
