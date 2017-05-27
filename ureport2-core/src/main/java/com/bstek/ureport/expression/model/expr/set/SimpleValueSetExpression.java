package com.bstek.ureport.expression.model.expr.set;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月1日
 */
public class SimpleValueSetExpression extends BaseExpression {
	private Object simpleValue;
	public SimpleValueSetExpression(Object simpleValue) {
		this.simpleValue=simpleValue;
	}
	@Override
	protected ExpressionData<?> compute(Cell cell,Cell currentCell,Context context) {
		return new ObjectExpressionData(simpleValue);
	}
}
