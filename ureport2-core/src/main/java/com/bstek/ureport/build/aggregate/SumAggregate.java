package com.bstek.ureport.build.aggregate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.Utils;
import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.definition.value.Value;
import com.bstek.ureport.exception.ReportComputeException;
import com.bstek.ureport.expression.model.Condition;
import com.bstek.ureport.expression.model.expr.dataset.DatasetExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月20日
 */
public class SumAggregate extends Aggregate {
	@Override
	public List<BindData> aggregate(DatasetExpression expr, Cell cell,Context context) {
		String datasetName=expr.getDatasetName();
		String property=expr.getProperty();
		Cell leftCell=fetchLeftCell(cell, context, datasetName);
		Cell topCell=fetchTopCell(cell, context, datasetName);
		List<Object> leftList=null,topList=null;
		if(leftCell!=null){
			leftList=leftCell.getBindData();
		}
		if(topCell!=null){
			topList=topCell.getBindData();
		}
		BigDecimal result=null;
		if(leftList==null && topList==null){
			List<?> data=context.getDatasetData(datasetName);
			result=buildSum(data,property,cell,expr,context);
		}else if(leftList==null){
			result=buildSum(topList,property,cell,expr,context);
		}else if(topList==null){
			result=buildSum(leftList,property,cell,expr,context);
		}else{
			List<Object> list=null;
			Object data=null;
			String prop=null;
			if(leftList.size()>topList.size()){
				list=topList;
				data=leftCell.getData();
				Value value=leftCell.getValue();
				DatasetExpression de=fetchDatasetExpression(value);
				if(de==null){
					throw new ReportComputeException("Unsupport value : "+value);
				}
				prop=de.getProperty();
			}else{
				list=leftList;
				data=topCell.getData();
				Value value=topCell.getValue();
				DatasetExpression de=fetchDatasetExpression(value);
				if(de==null){
					throw new ReportComputeException("Unsupport value : "+value);
				}
				prop=de.getProperty();
			}
			Condition condition=getCondition(cell);
			if(condition==null){
				condition=expr.getCondition();
			}
			result=new BigDecimal(0);
			for(Object obj:list){
				if(condition!=null && !condition.filter(cell, cell, obj, context)){
					continue;
				}
				Object o=Utils.getProperty(obj, prop);
				if((o!=null && data!=null && (o==data || o.equals(data))) || (o==null && data==null)){
					Object value=Utils.getProperty(obj, property);
					if(value==null || value.toString().equals("")){
						continue;
					}
					result=result.add(Utils.toBigDecimal(value));
				}
			}
		}
		List<BindData> list=new ArrayList<BindData>();
		list.add(new BindData(result.doubleValue(),null));
		return list;
	}
	
	private BigDecimal buildSum(List<?> list,String property,Cell cell,DatasetExpression expr,Context context){
		BigDecimal result=new BigDecimal(0);
		Condition condition=getCondition(cell);
		if(condition==null){
			condition=expr.getCondition();
		}
		for(Object obj:list){
			if(condition!=null && !condition.filter(cell, cell, obj, context)){
				continue;
			}
			Object value=Utils.getProperty(obj, property);
			if(value==null || value.toString().equals("")){
				continue;
			}
			result=result.add(Utils.toBigDecimal(value));
		}
		return result;
	}
}