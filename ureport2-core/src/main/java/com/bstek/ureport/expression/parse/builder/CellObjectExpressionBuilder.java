package com.bstek.ureport.expression.parse.builder;

import com.bstek.ureport.dsl.ReportParserParser.CellContext;
import com.bstek.ureport.dsl.ReportParserParser.PropertyContext;
import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.cell.CellObjectExpression;

/**
 * @author Jacky.gao
 * @since 2017年1月20日
 */
public class CellObjectExpressionBuilder implements ExpressionBuilder {

	@Override
	public BaseExpression build(UnitContext unitContext) {
		CellContext ctx=unitContext.cell();
		String property=null;
		PropertyContext propCtx=ctx.property();
		if(propCtx!=null){
			property=propCtx.getText();
		}
		CellObjectExpression expr=new CellObjectExpression(property);
		expr.setExpr(ctx.getText());
		return expr;
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.cell()!=null;
	}
}
