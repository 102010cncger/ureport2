package com.bstek.ureport.build.compute;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.definition.value.ValueType;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年12月21日
 */
public class SimpleValueCompute implements ValueCompute {

	@Override
	public List<BindData> compute(Cell cell, Context context) {
		List<BindData> list=new ArrayList<BindData>();
		list.add(new BindData(cell.getValue().getValue(),null));
		return list;
	}

	@Override
	public ValueType type() {
		return ValueType.simple;
	}
}
