package com.bstek.ureport.expression.model.condition;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.Expression;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年11月22日
 */
public class BothExpressionCondition extends BaseCondition {
	private ConditionType type=ConditionType.expression;
	@JsonIgnore
	private Expression leftExpression;
	@JsonIgnore
	private Expression rightExpression;

	@Override
	Object computeLeft(Cell cell,Cell currentCell, Object obj, Context context) {
		ExpressionData<?> exprData = leftExpression.execute(cell,currentCell, context);
		return extractExpressionData(exprData);
	}

	@Override
	Object computeRight(Cell cell, Cell currentCell,Object obj, Context context) {
		ExpressionData<?> exprData = rightExpression.execute(cell,currentCell, context);
		return extractExpressionData(exprData);
	}
	
	
	@Override
	public ConditionType getType() {
		return type;
	}

	public void setLeftExpression(Expression leftExpression) {
		this.leftExpression = leftExpression;
	}

	public void setRightExpression(Expression rightExpression) {
		this.rightExpression = rightExpression;
	}
}
