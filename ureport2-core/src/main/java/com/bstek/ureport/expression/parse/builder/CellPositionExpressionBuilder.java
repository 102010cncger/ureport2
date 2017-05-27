package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.CellPositionContext;
import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.CellPositionExpression;

/**
 * @author Jacky.gao
 * @since 2017年1月21日
 */
public class CellPositionExpressionBuilder implements ExpressionBuilder {

	@Override
	public BaseExpression build(UnitContext unitContext) {
		CellPositionContext ctx=unitContext.cellPosition();
		CellPositionExpression expr=new CellPositionExpression(ctx.Cell().getText());
		return expr;
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.cellPosition()!=null;
	}
}
