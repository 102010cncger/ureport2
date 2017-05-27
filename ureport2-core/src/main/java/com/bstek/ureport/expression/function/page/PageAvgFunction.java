package com.bstek.ureport.expression.function.page;

import java.math.BigDecimal;
import java.util.List;

import com.bstek.ureport.Utils;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectListExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年5月5日
 */
public class PageAvgFunction extends PageFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		if(dataList==null){
			return 0;
		}
		int size=0;
		BigDecimal total=new BigDecimal(0);
		for(ExpressionData<?> exprData:dataList){
			if(exprData instanceof ObjectListExpressionData){
				ObjectListExpressionData listExpr=(ObjectListExpressionData)exprData;
				List<?> list=listExpr.getData();
				for(Object obj:list){
					if(obj==null){
						continue;
					}
					BigDecimal bigData=Utils.toBigDecimal(obj);
					total=total.add(bigData);
					size++;
				}
			}
		}
		return total.divide(new BigDecimal(size), 8, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public String name() {
		return "pavg";
	}
}
