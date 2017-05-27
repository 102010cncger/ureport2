package com.bstek.ureport.expression.model.expr.ifelse;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.Expression;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月16日
 */
public class IfExpression extends BaseExpression {
	private ExpressionConditionList conditionList;
	private Expression expression;
	private List<ElseIfExpression> elseIfExpressions;
	private ElseExpression elseExpression;
	@Override
	protected ExpressionData<?> compute(Cell cell,Cell currentCell, Context context) {
		if(conditionList!=null){
			boolean result=conditionList.eval(context, cell,currentCell);
			if(result){
				return expression.execute(cell, currentCell,context);
			}
		}
		if(elseIfExpressions!=null){				
			for(ElseIfExpression elseIfExpr:elseIfExpressions){
				if(elseIfExpr.conditionsEval(cell, currentCell,context)){
					return elseIfExpr.execute(cell,currentCell, context);
				}
			}
		}
		if(elseExpression!=null){
			return elseExpression.execute(cell,currentCell, context);
		}
		return new ObjectExpressionData(null);
	}
	public void setConditionList(ExpressionConditionList conditionList) {
		this.conditionList = conditionList;
	}
	public void setElseExpression(ElseExpression elseExpression) {
		this.elseExpression = elseExpression;
	}
	public void setElseIfExpressions(List<ElseIfExpression> elseIfExpressions) {
		this.elseIfExpressions = elseIfExpressions;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	public Expression getExpression() {
		return expression;
	}
	public ElseExpression getElseExpression() {
		return elseExpression;
	}
	public List<ElseIfExpression> getElseIfExpressions() {
		return elseIfExpressions;
	}
}
