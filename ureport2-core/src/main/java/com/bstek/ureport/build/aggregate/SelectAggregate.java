package com.bstek.ureport.build.aggregate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bstek.ureport.Utils;
import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.definition.Order;
import com.bstek.ureport.expression.model.expr.dataset.DatasetExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年12月22日
 */
public class SelectAggregate extends Aggregate {
	@Override
	public List<BindData> aggregate(DatasetExpression expr,Cell cell, Context context) {
		List<?> objList=fetchData(cell, context, expr.getDatasetName());
		return doAggregate(expr, cell, context, objList);
	}

	protected List<BindData> doAggregate(DatasetExpression expr, Cell cell,Context context, List<?> objList) {
		List<BindData> list=new ArrayList<BindData>();
		Map<String,String> mappingMap=expr.getMapping();
		String property=expr.getProperty();
		for(Object o:objList){
			boolean conditionResult=doCondition(expr.getCondition(),cell,o,context);
			if(!conditionResult){
				continue;
			}
			List<Object> bindList=new ArrayList<Object>();
			bindList.add(o);
			Object data=Utils.getProperty(o, property);
			data=mappingData(mappingMap,data);
			list.add(new BindData(data,bindList));
		}
		if(list.size()==0){
			List<Object> rowList=new ArrayList<Object>();
			rowList.add(new HashMap<String,Object>());
			list.add(new BindData("",rowList));
		}
		if(list.size()>1){
			Order order=expr.getOrder();
			orderBindDataList(list, order);			
		}
		return list;
	}
}
