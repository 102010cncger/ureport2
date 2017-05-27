package com.bstek.ureport.expression.function.page;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年5月5日
 */
public class PageRowsFunction extends PageFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		return context.getCurrentPageRows().size();
	}

	@Override
	public String name() {
		return "prows";
	}
}
