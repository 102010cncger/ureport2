package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.IntegerExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月24日
 */
public class IntegerExpressionBuilder implements ExpressionBuilder{
	@Override
	public BaseExpression build(UnitContext unitContext) {
		Integer value=null;
		if(unitContext.INTEGER()!=null){
			value=Integer.valueOf(unitContext.INTEGER().getText());
		}
		return new IntegerExpression(value);
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.INTEGER()!=null;
	}

}
