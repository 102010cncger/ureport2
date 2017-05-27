package com.bstek.ureport.build.cell;

import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年11月1日
 */
public interface CellBuilder {
	void buildCell(List<BindData> dataList, Cell cell, Context context);
}
