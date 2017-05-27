package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.NullExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月25日
 */
public class NullExpressionBuilder implements ExpressionBuilder {
	@Override
	public BaseExpression build(UnitContext unitContext) {
		return new NullExpression();
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.NULL()!=null;
	}
}
