package com.bstek.ureport.expression.function;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年12月27日
 */
public interface Function {
	Object execute(List<ExpressionData<?>> dataList,Context context,Cell currentCell);
	String name();
}
