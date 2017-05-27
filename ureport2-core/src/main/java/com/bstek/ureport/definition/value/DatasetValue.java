package com.bstek.ureport.definition.value;

import com.bstek.ureport.expression.model.expr.dataset.DatasetExpression;

/**
 * @author Jacky.gao
 * @since 2016年12月21日
 */
public class DatasetValue extends DatasetExpression implements Value{
	
	@Override
	public ValueType getType() {
		return ValueType.dataset;
	}
	
	@Override
	public String getValue() {
		StringBuffer sb=new StringBuffer();
		sb.append(getDatasetName());
		sb.append(".");
		sb.append(getAggregate().name());
		sb.append("(");
		String prop=getProperty();
		if(prop!=null){
			if(prop.length()>13){
				prop=prop.substring(0,10)+"...";
			}
			sb.append(prop);
		}
		sb.append(")");
		return sb.toString();
	}
}
