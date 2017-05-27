package com.bstek.ureport.expression.function.page;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.bstek.ureport.Utils;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.data.ObjectListExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年5月5日
 */
public class PageMinFunction extends PageFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		if(dataList==null){
			return 0;
		}
		BigDecimal value=null;
		for(ExpressionData<?> exprData:dataList){
			if(exprData instanceof ObjectListExpressionData){
				ObjectListExpressionData listExpr=(ObjectListExpressionData)exprData;
				List<?> list=listExpr.getData();
				for(Object obj:list){
					if(obj==null || StringUtils.isBlank(obj.toString())){
						continue;
					}
					BigDecimal bigData=Utils.toBigDecimal(obj);
					if(value==null){
						value=bigData;
					}else{
						int result=value.compareTo(bigData);
						if(result==1){
							value=bigData;
						}
					}
				}
			}else if(exprData instanceof ObjectExpressionData){
				Object obj=exprData.getData();
				if(obj!=null && StringUtils.isNotBlank(obj.toString())){
					value=Utils.toBigDecimal(obj);
				}
			}
		}
		return value;
	}

	@Override
	public String name() {
		return "pmin";
	}
}
