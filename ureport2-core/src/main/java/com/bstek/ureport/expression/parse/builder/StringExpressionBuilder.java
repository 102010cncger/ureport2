package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.StringExpression;


/**
 * @author Jacky.gao
 * @since 2016年12月23日
 */
public class StringExpressionBuilder implements ExpressionBuilder {
	@Override
	public BaseExpression build(UnitContext unitContext) {
		String text=unitContext.STRING().getText();
		text=text.substring(1,text.length()-1);
		StringExpression stringExpr=new StringExpression(text);
		return stringExpr;
	}
	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.STRING()!=null;
	}
}
