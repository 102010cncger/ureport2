package com.bstek.ureport.expression.function.math;

import java.math.BigDecimal;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * 求方差
 * @author Jacky.gao
 * @since 2017年1月23日
 */
public class VaraFunction extends MathFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		List<BigDecimal> list=buildDataList(dataList);
		BigDecimal total=new BigDecimal(0);
		for(BigDecimal bigData:list){
			total=total.add(bigData);
		}
		int size=list.size();
		BigDecimal avg=total.divide(new BigDecimal(size),8,BigDecimal.ROUND_HALF_UP);
		double sum=0;
		for(BigDecimal bigData:list){
			BigDecimal data=bigData.subtract(avg);
			sum+=Math.pow(data.doubleValue(), 2);
		}
		BigDecimal result=new BigDecimal(sum);
		return result.divide(new BigDecimal(size),8,BigDecimal.ROUND_HALF_UP);
	}
	
	
	@Override
	public String name() {
		return "vara";
	}
}
