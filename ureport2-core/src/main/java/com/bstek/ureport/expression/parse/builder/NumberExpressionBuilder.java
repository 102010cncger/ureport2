package com.bstek.ureport.expression.parse.builder;

import java.math.BigDecimal;

import com.bstek.ureport.Utils;
import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.NumberExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月25日
 */
public class NumberExpressionBuilder implements ExpressionBuilder {
	@Override
	public BaseExpression build(UnitContext unitContext) {
		BigDecimal value=Utils.toBigDecimal(unitContext.NUMBER().getText());
		return new NumberExpression(value);
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.NUMBER()!=null;
	}
}
