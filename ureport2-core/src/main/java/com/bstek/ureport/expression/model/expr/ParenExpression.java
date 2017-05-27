package com.bstek.ureport.expression.model.expr;

import java.util.List;

import com.bstek.ureport.expression.model.Operator;


/**
 * @author Jacky.gao
 * @since 2016年11月18日
 */
public class ParenExpression extends JoinExpression {
	public ParenExpression(List<Operator> operators,List<BaseExpression> expressions) {
		super(operators, expressions);
	}
}
