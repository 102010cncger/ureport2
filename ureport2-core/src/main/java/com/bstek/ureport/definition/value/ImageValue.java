package com.bstek.ureport.definition.value;

import com.bstek.ureport.expression.model.Expression;

/**
 * @author Jacky.gao
 * @since 2017年1月24日
 */
public class ImageValue implements Value {
	private String path;
	private String expr;
	private Expression expression;
	private Source source;
	@Override
	public ValueType getType() {
		return ValueType.image;
	}
	@Override
	public String getValue() {
		if(this.source.equals(Source.text)){
			return path;
		}else{
			return expr;
		}
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Source getSource() {
		return source;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setExpr(String expr) {
		this.expr = expr;
	}
	public String getExpr() {
		return expr;
	}
	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
}
