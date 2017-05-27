package com.bstek.ureport.expression.model;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年11月18日
 */
public interface Expression {
	ExpressionData<?> execute(Cell cell,Cell currentCell,Context context);
}
