package com.bstek.ureport.parser.impl;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import com.bstek.ureport.definition.Band;
import com.bstek.ureport.definition.RowDefinition;
import com.bstek.ureport.parser.Parser;

/**
 * @author Jacky.gao
 * @since 2016年12月5日
 */
public class RowParser implements Parser<RowDefinition> {
	@Override
	public RowDefinition parse(Element element) {
		RowDefinition row=new RowDefinition();
		row.setRowNumber(Integer.valueOf(element.attributeValue("row-number")));
		String height=element.attributeValue("height");
		if(StringUtils.isNotBlank(height)){
			row.setHeight(Integer.valueOf(height));
		}
		String band=element.attributeValue("band");
		if(StringUtils.isNotBlank(band)){
			row.setBand(Band.valueOf(band));
		}
		return row;
	}
}
