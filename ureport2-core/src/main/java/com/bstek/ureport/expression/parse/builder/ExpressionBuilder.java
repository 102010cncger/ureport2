package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月23日
 */
public interface ExpressionBuilder {
	BaseExpression build(UnitContext unitContext);
	boolean support(UnitContext unitContext);
}
