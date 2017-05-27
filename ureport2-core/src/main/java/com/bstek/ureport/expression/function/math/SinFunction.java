package com.bstek.ureport.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月23日
 */
public class SinFunction extends MathFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		BigDecimal data=buildBigDecimal(dataList);
		return Math.sin(data.doubleValue());
	}

	@Override
	public String name() {
		return "sin";
	}
}
