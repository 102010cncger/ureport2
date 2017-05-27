package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.BooleanExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月25日
 */
public class BooleanExpressionBuilder implements ExpressionBuilder {
	@Override
	public BaseExpression build(UnitContext unitContext) {
		String text=unitContext.BOOLEAN().getText();
		return new BooleanExpression(Boolean.valueOf(text));
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.BOOLEAN()!=null;
	}
}
