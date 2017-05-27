package com.bstek.ureport.build.aggregate;

import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.expr.dataset.DatasetExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月20日
 */
public class ReselectAggregate extends SelectAggregate {
	@Override
	public List<BindData> aggregate(DatasetExpression expr, Cell cell,Context context) {
		List<?> objList=context.getDatasetData(expr.getDatasetName());
		return doAggregate(expr, cell, context,objList);
	}
}
