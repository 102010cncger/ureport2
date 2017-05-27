package com.bstek.ureport.expression.model.expr.cell;

import org.apache.commons.lang.StringUtils;

import com.bstek.ureport.Utils;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月20日
 */
public class CellObjectExpression extends BaseExpression {
	private String property;
	public CellObjectExpression(String property) {
		this.property=property;
	}
	@Override
	protected ExpressionData<?> compute(Cell cell, Cell currentCell,Context context) {
		while(!context.isCellPocessed(cell.getName())){
			context.getReportBuilder().buildCell(context, null);
		}
		if(StringUtils.isNotBlank(property)){
			Object obj=Utils.getProperty(cell, property);
			return new ObjectExpressionData(obj);
		}
		return new ObjectExpressionData(cell);
	}
}
