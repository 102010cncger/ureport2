package com.bstek.ureport.parser.impl.value;

import org.dom4j.Element;

import com.bstek.ureport.definition.value.SimpleValue;
import com.bstek.ureport.definition.value.Value;

/**
 * @author Jacky.gao
 * @since 2016年12月21日
 */
public class SimpleValueParser extends ValueParser {
	@Override
	public Value parse(Element element) {
		SimpleValue simpleValue=new SimpleValue(element.getText());
		return simpleValue;
	}
}
