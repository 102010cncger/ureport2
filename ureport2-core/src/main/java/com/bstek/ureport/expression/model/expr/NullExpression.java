package com.bstek.ureport.expression.model.expr;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.NoneExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年12月23日
 */
public class NullExpression extends BaseExpression {
	@Override
	public ExpressionData<?> compute(Cell cell, Cell currentCell,Context context) {
		return new NoneExpressionData();
	}
}
