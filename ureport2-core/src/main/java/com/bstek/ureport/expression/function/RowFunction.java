package com.bstek.ureport.expression.function;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.model.Row;

/**
 * @author Jacky.gao
 * @since 2017年4月25日
 */
public class RowFunction implements Function{
	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		Row row=currentCell.getRow();
		return row.getRowNumber();
	}
	@Override
	public String name() {
		return "row";
	}
}
