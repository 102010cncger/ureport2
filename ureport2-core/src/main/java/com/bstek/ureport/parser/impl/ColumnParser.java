package com.bstek.ureport.parser.impl;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import com.bstek.ureport.definition.ColumnDefinition;
import com.bstek.ureport.parser.Parser;

/**
 * @author Jacky.gao
 * @since 2016年12月5日
 */
public class ColumnParser implements Parser<ColumnDefinition> {
	@Override
	public ColumnDefinition parse(Element element) {
		ColumnDefinition col=new ColumnDefinition();
		col.setColumnNumber(Integer.valueOf(element.attributeValue("col-number")));
		String hide=element.attributeValue("hide");
		if(StringUtils.isNotBlank(hide)){
			col.setHide(Boolean.valueOf(hide));			
		}
		String width=element.attributeValue("width");
		if(StringUtils.isNotBlank(width)){
			col.setWidth(Integer.valueOf(width));
		}
		return col;
	}
}
