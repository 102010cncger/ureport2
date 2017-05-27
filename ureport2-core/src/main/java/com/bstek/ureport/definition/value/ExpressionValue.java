package com.bstek.ureport.definition.value;

import com.bstek.ureport.expression.ExpressionUtils;
import com.bstek.ureport.expression.model.Expression;

/**
 * @author Jacky.gao
 * @since 2016年12月24日
 */
public class ExpressionValue implements Value{
	private String text;
	private Expression expression;
	public ExpressionValue(String text) {
		this.text=text;
		expression=ExpressionUtils.parseExpression(text);
	}
	
	@Override
	public ValueType getType() {
		return ValueType.expression;
	}
	@Override
	public String getValue() {
		return text;
	}
	public Expression getExpression() {
		return expression;
	}
}
