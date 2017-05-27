package com.bstek.ureport.expression.function.page;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年4月17日
 */
public class PageTotalFunction extends PageFunction{
	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		return context.getTotalPages();
	}
	@Override
	public String name() {
		return "pages";
	}
}
