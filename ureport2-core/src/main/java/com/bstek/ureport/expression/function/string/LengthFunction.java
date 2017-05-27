package com.bstek.ureport.expression.function.string;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月24日
 */
public class LengthFunction extends StringFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		String text=buildString(dataList);
		return text.length();
	}

	@Override
	public String name() {
		return "length";
	}
}
