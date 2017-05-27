package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.RelativeCellContext;
import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.RelativeCellExpression;

/**
 * @author Jacky.gao
 * @since 2017年1月21日
 */
public class RelativeCellExpressionBuilder implements ExpressionBuilder {

	@Override
	public BaseExpression build(UnitContext unitContext) {
		RelativeCellContext ctx=unitContext.relativeCell();
		RelativeCellExpression expr=new RelativeCellExpression(ctx.Cell().getText());
		return expr;
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.relativeCell()!=null;
	}
}
