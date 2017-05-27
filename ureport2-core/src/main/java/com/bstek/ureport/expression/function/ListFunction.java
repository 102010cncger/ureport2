package com.bstek.ureport.expression.function;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.data.ObjectListExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月3日
 */
public class ListFunction implements Function {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		List<Object> list= new ArrayList<Object>();
		for(ExpressionData<?> d:dataList){
			if(d instanceof ObjectExpressionData){
				ObjectExpressionData exprData=(ObjectExpressionData)d;
				list.add(exprData.getData());
			}else if(d instanceof ObjectListExpressionData){
				ObjectListExpressionData listData=(ObjectListExpressionData)d;
				list.addAll(listData.getData());
			}
		}
		return list;
	}

	@Override
	public String name() {
		return "list";
	}
}
