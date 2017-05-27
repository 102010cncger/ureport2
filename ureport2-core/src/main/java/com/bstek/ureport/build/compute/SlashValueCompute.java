package com.bstek.ureport.build.compute;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.definition.value.SlashValue;
import com.bstek.ureport.definition.value.ValueType;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.model.Image;

/**
 * @author Jacky.gao
 * @since 2017年3月14日
 */
public class SlashValueCompute implements ValueCompute {
	@Override
	public List<BindData> compute(Cell cell, Context context) {
		List<BindData> list=new ArrayList<BindData>();
		SlashValue v=(SlashValue)cell.getValue();
		Image img=new Image(v.getBase64Data(),"slash.png",0,0);
		BindData bindData=new BindData(img);
		list.add(bindData);
		/*String key=SlashBuilder.buildKey(context.getReport().getReportFullName(), cell.getName());
		Resource res=new Resource(key);
		BindData bindData=new BindData(res);
		list.add(bindData);*/
		return list;
	}


	@Override
	public ValueType type() {
		return ValueType.slash;
	}
}
