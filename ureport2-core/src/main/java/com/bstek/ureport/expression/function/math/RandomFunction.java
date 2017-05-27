package com.bstek.ureport.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月23日
 */
public class RandomFunction extends MathFunction {
	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		int feed=0;
		if(dataList.size()>0){
			BigDecimal data=buildBigDecimal(dataList);
			feed=data.intValue();
		}
		if(feed==0){
			return Math.random();
		}
		return RandomUtils.nextInt(feed);
	}

	@Override
	public String name() {
		return "random";
	}
}
