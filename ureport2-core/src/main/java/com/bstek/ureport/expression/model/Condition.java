package com.bstek.ureport.expression.model;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年11月18日
 */
public interface Condition {
	/**
	 * @param cell 当前Condition所在的单元格
	 * @param obj 要判断的对象
	 * @param context 上下文对象
	 * @return 返回是否符合条件
	 */
	boolean filter(Cell cell,Cell currentCell,Object obj,Context context);
}
