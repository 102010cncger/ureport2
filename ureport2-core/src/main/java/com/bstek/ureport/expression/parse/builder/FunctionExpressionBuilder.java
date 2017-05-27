package com.bstek.ureport.expression.parse.builder;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.dsl.ReportParserParser.FunctionContext;
import com.bstek.ureport.dsl.ReportParserParser.FunctionParameterContext;
import com.bstek.ureport.dsl.ReportParserParser.SetContext;
import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.FunctionExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月26日
 */
public class FunctionExpressionBuilder extends BaseExpressionBuilder {
	private SetExpressionBuilder setExpressionBuilder;
	public FunctionExpressionBuilder() {
		setExpressionBuilder=new SetExpressionBuilder();
	}
	@Override
	public BaseExpression build(UnitContext unitContext) {
		FunctionContext ctx=unitContext.function();
		FunctionExpression expr=new FunctionExpression();
		expr.setExpr(ctx.getText());
		expr.setName(ctx.Identifier().getText());
		FunctionParameterContext functionParameterContext=ctx.functionParameter();
		if(functionParameterContext!=null){
			List<BaseExpression> exprList=new ArrayList<BaseExpression>();
			List<SetContext> setContextList=functionParameterContext.set();
			for(SetContext setContext:setContextList){
				BaseExpression setExpr=setExpressionBuilder.buildSetExpression(setContext);
				exprList.add(setExpr);
			}
			expr.setExpressions(exprList);
		}
		return expr;
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.function()!=null;
	}
}
