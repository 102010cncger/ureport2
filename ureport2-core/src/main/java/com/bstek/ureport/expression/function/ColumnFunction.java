package com.bstek.ureport.expression.function;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.model.Column;

/**
 * @author Jacky.gao
 * @since 2017年4月25日
 */
public class ColumnFunction implements Function{
	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		Column col=currentCell.getColumn();
		return col.getColumnNumber();
	}
	@Override
	public String name() {
		return "column";
	}
}
