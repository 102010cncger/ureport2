package com.bstek.ureport.build.cell;

import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.definition.ConditionPropertyItem;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年11月1日
 */
public class NoneExpandBuilder implements CellBuilder {

	@Override
	public void buildCell(List<BindData> dataList, Cell cell, Context context) {
		Object obj=null;
		List<Object> bindData=null;
		for(BindData data:dataList){
			if(obj==null){
				obj=data.getValue();
			}else{
				obj=obj+","+data.getValue();
			}
			bindData=data.getDataList();
		}
		cell.setData(obj);
		cell.setBindData(bindData);
		List<ConditionPropertyItem> conditionPropertyItems=cell.getConditionPropertyItems();
		if(conditionPropertyItems!=null && conditionPropertyItems.size()>0){
			context.getReport().getLazyComputeCells().add(cell);
		}else{
			cell.doFormat();
			cell.doDataWrapCompute(context);
		}
	}
}
