package com.bstek.ureport.build.compute;

import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.build.DatasetUtils;
import com.bstek.ureport.definition.value.ValueType;
import com.bstek.ureport.expression.model.expr.dataset.DatasetExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年12月21日
 */
public class DatasetValueCompute implements ValueCompute {
	@Override
	public List<BindData> compute(Cell cell, Context context) {
		DatasetExpression expr=(DatasetExpression)cell.getValue();
		return DatasetUtils.computeDatasetExpression(expr, cell, context);
	}
	@Override
	public ValueType type() {
		return ValueType.dataset;
	}
}
