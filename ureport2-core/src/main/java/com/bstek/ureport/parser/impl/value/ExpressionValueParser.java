package com.bstek.ureport.parser.impl.value;

import org.dom4j.Element;

import com.bstek.ureport.definition.value.ExpressionValue;

/**
 * @author Jacky.gao
 * @since 2016年12月30日
 */
public class ExpressionValueParser extends ValueParser{
	@Override
	public ExpressionValue parse(Element element) {
		ExpressionValue value=new ExpressionValue(element.getText());
		return value;
	}
}
