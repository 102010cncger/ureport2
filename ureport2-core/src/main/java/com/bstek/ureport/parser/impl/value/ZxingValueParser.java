package com.bstek.ureport.parser.impl.value;

import org.dom4j.Element;

import com.bstek.ureport.definition.value.Source;
import com.bstek.ureport.definition.value.Value;
import com.bstek.ureport.definition.value.ZxingCategory;
import com.bstek.ureport.definition.value.ZxingValue;
import com.bstek.ureport.expression.ExpressionUtils;
import com.bstek.ureport.expression.model.Expression;

/**
 * @author Jacky.gao
 * @since 2017年3月6日
 */
public class ZxingValueParser extends ValueParser {

	@Override
	public Value parse(Element element) {
		ZxingValue value=new ZxingValue();
		Source source=Source.valueOf(element.attributeValue("source"));
		value.setSource(source);
		value.setWidth(Integer.valueOf(element.attributeValue("width")));
		value.setHeight(Integer.valueOf(element.attributeValue("height")));
		value.setFormat(element.attributeValue("format"));
		value.setCategory(ZxingCategory.valueOf(element.attributeValue("category")));
		value.setCodeDisplay(Boolean.valueOf(element.attributeValue("code-display")));
		for(Object obj:element.elements()){
			if(obj==null || !(obj instanceof Element)){
				continue;
			}
			Element ele=(Element)obj;
			if(ele.getName().equals("text")){
				if(source.equals(Source.text)){
					value.setText(ele.getText());					
				}else{
					value.setExpr(ele.getText());					
				}
				break;
			}
		}
		if(source.equals(Source.expression)){
			String expr=value.getExpr();
			Expression expression=ExpressionUtils.parseExpression(expr);
			value.setExpression(expression);
		}
		return value;
	}
}
