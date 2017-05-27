package com.bstek.ureport.expression.model.expr;

import java.math.BigDecimal;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年12月23日
 */
public class NumberExpression extends BaseExpression {
	private BigDecimal value;
	public NumberExpression(BigDecimal value) {
		this.value=value;
	}
	@Override
	public ExpressionData<?> compute(Cell cell, Cell currentCell,Context context) {
		return new ObjectExpressionData(value.floatValue());
	}
}
