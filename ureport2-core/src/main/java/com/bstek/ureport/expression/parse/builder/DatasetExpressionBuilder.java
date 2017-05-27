package com.bstek.ureport.expression.parse.builder;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.bstek.ureport.definition.Order;
import com.bstek.ureport.definition.value.AggregateType;
import com.bstek.ureport.dsl.ReportParserParser.ConditionsContext;
import com.bstek.ureport.dsl.ReportParserParser.DatasetContext;
import com.bstek.ureport.dsl.ReportParserParser.UnitContext;
import com.bstek.ureport.expression.model.condition.BaseCondition;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.expression.model.expr.dataset.DatasetExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月26日
 */
public class DatasetExpressionBuilder extends BaseExpressionBuilder {
	@Override
	public BaseExpression build(UnitContext unitContext) {
		DatasetContext context=(DatasetContext)unitContext.dataset();
		DatasetExpression expr=new DatasetExpression();
		expr.setExpr(context.getText());
		expr.setDatasetName(context.Identifier().getText());
		expr.setAggregate(AggregateType.valueOf(context.aggregate().getText()));
		if(context.property()!=null){
			expr.setProperty(context.property().getText());			
		}
		ConditionsContext conditionsContext=context.conditions();
		if(conditionsContext!=null){
			BaseCondition condition=buildConditions(conditionsContext);
			expr.setCondition(condition);
		}
		TerminalNode orderNode=context.ORDER();
		if(orderNode!=null){
			expr.setOrder(Order.valueOf(orderNode.getText()));
		}
		return expr;
	}

	@Override
	public boolean support(UnitContext unitContext) {
		return unitContext.dataset()!=null;
	}
}
