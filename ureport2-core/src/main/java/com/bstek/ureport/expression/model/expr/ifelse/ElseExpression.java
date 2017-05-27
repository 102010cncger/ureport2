package com.bstek.ureport.expression.model.expr.ifelse;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.Expression;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月16日
 */
public class ElseExpression extends BaseExpression {
	private Expression expression;
	@Override
	protected ExpressionData<?> compute(Cell cell,Cell currentCell, Context context) {
		return expression.execute(cell, currentCell,context);
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	public Expression getExpression() {
		return expression;
	}
}
